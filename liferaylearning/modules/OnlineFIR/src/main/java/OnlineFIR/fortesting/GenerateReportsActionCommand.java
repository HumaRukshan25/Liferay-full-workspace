package OnlineFIR.fortesting;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import fironlineser.model.FIRRR;
import fironlineser.model.PoliceStation;
import fironlineser.service.FIRRRLocalServiceUtil;
import fironlineser.service.PoliceStationLocalServiceUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
                "mvc.command.name=/admin/processReports"
        },
        service = MVCActionCommand.class
)
public class GenerateReportsActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(GenerateReportsActionCommand.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

        try {
            long firId = ParamUtil.getLong(actionRequest, "firId");
            FIRRR fir = FIRRRLocalServiceUtil.fetchFIRRR(firId);

            if (fir == null) {
                log.info("No FIR found with ID: " + firId);
                actionResponse.setRenderParameter("mvcPath", "/generateReports.jsp");
                return true;
            }

            List<PoliceStation> stationList = PoliceStationLocalServiceUtil.getPoliceStations(0,
                    PoliceStationLocalServiceUtil.getPoliceStationsCount());

            String folderPath = "D:\\firreport";
            File folder = new File(folderPath);
            if (!folder.exists() && !folder.mkdirs()) {
                log.error("Failed to create directory: " + folderPath);
            }

            String filePath = folderPath + "\\fir_report_" + firId + ".csv";
            boolean success = generateFIRReport(fir, stationList, filePath);

            if (success) {
                log.info("FIR report successfully generated at: " + filePath);
            } else {
                log.error("Failed to generate FIR report for ID: " + firId);
            }

        } catch (Exception e) {
            log.error("Error generating FIR report", e);
        }

        actionResponse.setRenderParameter("mvcPath", "/generateReports.jsp");
        return true;
    }

    private boolean generateFIRReport(FIRRR fir, List<PoliceStation> stationList, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {

            logDebugInfo(fir, stationList);

            writer.append("FIR ID,Complainant,Incident Date,Filed On,Completed On,Location,Details,Status,Timeline,Assigned Inspector,Station Name,Officer In-Charge,Created Date\n");

            String[] timelineData = parseTimeline(fir.getTimeline());
            String filedOn = timelineData[0];
            String completedOn = timelineData[1];

            String[] stationData = findStationInfo(stationList, fir.getIncidentLocation());
            String stationName = stationData[0];
            String officerInCharge = stationData[1];

            // Assigned Inspector from FIRRR table; fallback to officerInCharge only if empty
            String assignedInspector = fir.getAssignedInspector();
            if (assignedInspector == null || assignedInspector.trim().isEmpty()) {
                assignedInspector = officerInCharge; 
            }

            String[] data = {
                    String.valueOf(fir.getFirId()),
                    safeString(fir.getComplainantName(), "N/A"),
                    formatDate(fir.getIncidentDate()),
                    filedOn.isEmpty() ? "N/A" : filedOn,
                    completedOn.isEmpty() ? "N/A" : completedOn,
                    safeString(fir.getIncidentLocation(), "N/A"),
                    safeString(fir.getIncidentDetails(), "N/A"),
                    safeString(fir.getStatus(), "N/A"),
                    safeString(fir.getTimeline(), "N/A"),
                    safeString(assignedInspector, "N/A"),
                    stationName.isEmpty() ? "N/A" : stationName,
                    officerInCharge.isEmpty() ? "N/A" : officerInCharge,
                    formatDate(fir.getCreateDate())
            };

            writer.append(String.join(",", data)).append("\n");
            return true;

        } catch (IOException e) {
            log.error("Error writing to CSV file: " + filePath, e);
            return false;
        }
    }

    private String[] parseTimeline(String timeline) {
        String filedOn = "";
        String completedOn = "";

        if (timeline != null && !timeline.trim().isEmpty()) {
            String cleanTimeline = timeline.replaceAll(",", ";");
            String[] events = cleanTimeline.split("[;]");

            for (String event : events) {
                if (event.trim().isEmpty()) continue;
                String[] parts = event.split("[:=]", 2);
                if (parts.length >= 2) {
                    String key = parts[0].trim().toLowerCase();
                    String value = parts[1].trim();
                    if (key.contains("filed") || key.contains("submitted")) filedOn = value;
                    else if (key.contains("completed") || key.contains("closed")) completedOn = value;
                }
            }
        }

        return new String[]{filedOn, completedOn};
    }

    private String[] findStationInfo(List<PoliceStation> stations, String incidentLocation) {
        String stationName = "";
        String officerInCharge = "";

        if (incidentLocation != null && !incidentLocation.trim().isEmpty()) {
            String incidentLoc = incidentLocation.toLowerCase().trim();

            for (PoliceStation station : stations) {
                if (station.getJurisdictionArea() != null && !station.getJurisdictionArea().trim().isEmpty()) {
                    String jurisdiction = station.getJurisdictionArea().toLowerCase().trim();
                    boolean matches =
                            incidentLoc.contains(jurisdiction) ||
                                    jurisdiction.contains(incidentLoc) ||
                                    incidentLoc.matches(".*\\b" + jurisdiction + "\\b.*") ||
                                    jurisdiction.matches(".*\\b" + incidentLoc + "\\b.*") ||
                                    getPartialMatchScore(incidentLoc, jurisdiction) > 0.7;

                    if (matches) {
                        stationName = safeString(station.getStationName(), "");
                        officerInCharge = safeString(station.getOfficerInCharge(), "");
                        log.info("Matched station: " + stationName + " for location: " + incidentLocation);
                        break;
                    }
                }
            }
        }

        if (stationName.isEmpty()) {
            log.warn("No police station found for location: " + incidentLocation);
        }

        return new String[]{stationName, officerInCharge};
    }

    private double getPartialMatchScore(String str1, String str2) {
        if (str1 == null || str2 == null) return 0.0;
        String shorter = str1.length() < str2.length() ? str1 : str2;
        String longer = str1.length() < str2.length() ? str2 : str1;
        if (longer.contains(shorter)) return (double) shorter.length() / longer.length();
        return 0.0;
    }

    private String safeString(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) return defaultValue;
        return value.replaceAll(",", ";").replaceAll("\\n", " ").replaceAll("\\r", " ").trim();
    }

    private String formatDate(java.util.Date date) {
        if (date == null) return "N/A";
        try { return sdf.format(date); }
        catch (Exception e) { log.error("Error formatting date: " + date, e); return "Invalid Date"; }
    }

    private void logDebugInfo(FIRRR fir, List<PoliceStation> stationList) {
        log.info("=== FIR Data Debug Info ===");
        log.info("FIR ID: " + fir.getFirId());
        log.info("Complainant: " + fir.getComplainantName());
        log.info("Incident Date: " + fir.getIncidentDate());
        log.info("Incident Location: " + fir.getIncidentLocation());
        log.info("Incident Details: " + fir.getIncidentDetails());
        log.info("Status: " + fir.getStatus());
        log.info("Timeline: " + fir.getTimeline());
        log.info("Assigned Inspector: " + fir.getAssignedInspector());
        log.info("Create Date: " + fir.getCreateDate());

        log.info("=== Available Police Stations ===");
        for (PoliceStation station : stationList) {
            log.info("Station: " + station.getStationName() +
                    ", Jurisdiction: " + station.getJurisdictionArea() +
                    ", Officer: " + station.getOfficerInCharge());
        }
        log.info("=== End Debug Info ===");
    }
}

