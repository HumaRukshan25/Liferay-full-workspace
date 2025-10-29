//package OnlinrFIRcitizen.portlet;
//
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.portlet.PortletException;
//import java.text.SimpleDateFormat;
//
//import org.osgi.service.component.annotations.Component;
//
//import OnlinrFIRcitizen.constants.OnlinrFIRcitizenPortletKeys;
//import fironlineser.model.FIRRR;
//import fironlineser.service.FIRRRLocalServiceUtil;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlinrFIRcitizenPortletKeys.ONLINRFIRCITIZEN,
//        "mvc.command.name=/fir/manageFIRAction"
//    },
//    service = MVCActionCommand.class
//)
//public class FileFIRMVCActionCommand implements MVCActionCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(FileFIRMVCActionCommand.class);
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
//            throws PortletException {
//
//        String actionType = ParamUtil.getString(actionRequest, "actionType");
//        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        long userId = themeDisplay.getUserId();
//
//        try {
//            if ("add".equalsIgnoreCase(actionType)) {
//                addFIR(actionRequest, userId);
//            } else if ("update".equalsIgnoreCase(actionType)) {
//                updateFIR(actionRequest);
//            } else if ("delete".equalsIgnoreCase(actionType)) {
//                deleteFIR(actionRequest);
//            }
//
//            // Redirect to render command to refresh table
//            actionResponse.setRenderParameter("mvcRenderCommandName", "/citizen/fileFIR");
//
//        } catch (Exception e) {
//            log.error("Error in FIR management", e);
//        }
//
//        return true;
//    }
//
//    private void addFIR(ActionRequest actionRequest, long userId) throws Exception {
//        String complainantName = ParamUtil.getString(actionRequest, "complainantName");
//        String incidentDateStr = ParamUtil.getString(actionRequest, "incidentDate");
//        String incidentLocation = ParamUtil.getString(actionRequest, "incidentLocation");
//        String incidentDetails = ParamUtil.getString(actionRequest, "incidentDetails");
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date incidentDate = sdf.parse(incidentDateStr);
//        java.util.Date now = new java.util.Date();
//
//        long firId = CounterLocalServiceUtil.increment(FIRRR.class.getName());
//        FIRRR fir = FIRRRLocalServiceUtil.createFIRRR(firId);
//
//        fir.setComplainantName(complainantName);
//        fir.setIncidentDate(incidentDate);
//        fir.setIncidentLocation(incidentLocation);
//        fir.setIncidentDetails(incidentDetails);
//        fir.setStatus("Pending");
//        fir.setTimeline("");
//        fir.setModificationDetails("");
//        fir.setUserId(userId);
//        fir.setCreateDate(now);
//        fir.setModifiedDate(now);
//
//        FIRRRLocalServiceUtil.addFIRRR(fir);
//        log.info("FIR filed successfully: " + firId);
//    }
//
//    private void updateFIR(ActionRequest actionRequest) throws Exception {
//        long firId = ParamUtil.getLong(actionRequest, "firId");
//        FIRRR fir = FIRRRLocalServiceUtil.getFIRRR(firId);
//
//        fir.setComplainantName(ParamUtil.getString(actionRequest, "complainantName"));
//        String incidentDateStr = ParamUtil.getString(actionRequest, "incidentDate");
//        if (!incidentDateStr.isEmpty()) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            fir.setIncidentDate(sdf.parse(incidentDateStr));
//        }
//        fir.setIncidentLocation(ParamUtil.getString(actionRequest, "incidentLocation"));
//        fir.setIncidentDetails(ParamUtil.getString(actionRequest, "incidentDetails"));
//        fir.setModifiedDate(new java.util.Date());
//
//        FIRRRLocalServiceUtil.updateFIRRR(fir);
//        log.info("FIR updated successfully: " + firId);
//    }
//
//    private void deleteFIR(ActionRequest actionRequest) throws Exception {
//        long firId = ParamUtil.getLong(actionRequest, "firId");
//        FIRRRLocalServiceUtil.deleteFIRRR(firId);
//        log.info("FIR deleted successfully: " + firId);
//    }
//}



package OnlinrFIRcitizen.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

import OnlinrFIRcitizen.constants.OnlinrFIRcitizenPortletKeys;
import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlinrFIRcitizenPortletKeys.ONLINRFIRCITIZEN,
        "mvc.command.name=/fir/manageFIRAction"
    },
    service = MVCActionCommand.class
)
public class FileFIRMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(FileFIRMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

        String actionType = ParamUtil.getString(actionRequest, "actionType");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();

        try {
            if ("add".equalsIgnoreCase(actionType)) {
                addFIR(actionRequest, userId);
            } else if ("update".equalsIgnoreCase(actionType)) {
                updateFIR(actionRequest);
            } else if ("delete".equalsIgnoreCase(actionType)) {
                deleteFIR(actionRequest);
            }

            // Redirect to refresh table
            actionResponse.setRenderParameter("mvcRenderCommandName", "/citizen/fileFIR");

        } catch (Exception e) {
            log.error("Error in FIR management", e);
        }

        return true;
    }

    private void addFIR(ActionRequest actionRequest, long userId) throws Exception {
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        String complainantName = uploadRequest.getParameter("complainantName");
        String incidentDateStr = uploadRequest.getParameter("incidentDate");
        String incidentLocation = uploadRequest.getParameter("incidentLocation");
        String incidentDetails = uploadRequest.getParameter("incidentDetails");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date incidentDate = sdf.parse(incidentDateStr);
        Date now = new Date();

        long firId = CounterLocalServiceUtil.increment(FIRRR.class.getName());
        FIRRR fir = FIRRRLocalServiceUtil.createFIRRR(firId);

        fir.setComplainantName(complainantName);
        fir.setIncidentDate(incidentDate);
        fir.setIncidentLocation(incidentLocation);
        fir.setIncidentDetails(incidentDetails);
        fir.setStatus("Pending");
        fir.setTimeline("");
        fir.setModificationDetails("");
        fir.setUserId(userId);
        fir.setCreateDate(now);
        fir.setModifiedDate(now);

        // Handle proof file upload
        File file = uploadRequest.getFile("proofFile");
        String fileName = uploadRequest.getFileName("proofFile");

        if (file != null && file.exists()) {
            String uploadDir = "D:\\firproofs\\citizen\\"; // folder for citizen files
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            File destFile = new File(uploadDir + fileName);
            Files.copy(file.toPath(), destFile.toPath());

            fir.setProofFileName(fileName);
            fir.setProofFilePath(destFile.getAbsolutePath());
            log.info("Citizen proof file uploaded: " + destFile.getAbsolutePath());
        }

        FIRRRLocalServiceUtil.addFIRRR(fir);
        log.info("Citizen FIR filed successfully: " + firId);
    }

    private void updateFIR(ActionRequest actionRequest) throws Exception {
        long firId = ParamUtil.getLong(actionRequest, "firId");
        FIRRR fir = FIRRRLocalServiceUtil.getFIRRR(firId);

        fir.setComplainantName(ParamUtil.getString(actionRequest, "complainantName"));
        String incidentDateStr = ParamUtil.getString(actionRequest, "incidentDate");
        if (!incidentDateStr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fir.setIncidentDate(sdf.parse(incidentDateStr));
        }
        fir.setIncidentLocation(ParamUtil.getString(actionRequest, "incidentLocation"));
        fir.setIncidentDetails(ParamUtil.getString(actionRequest, "incidentDetails"));
        fir.setModifiedDate(new Date());

        FIRRRLocalServiceUtil.updateFIRRR(fir);
        log.info("Citizen FIR updated successfully: " + firId);
    }

    private void deleteFIR(ActionRequest actionRequest) throws Exception {
        long firId = ParamUtil.getLong(actionRequest, "firId");
        FIRRRLocalServiceUtil.deleteFIRRR(firId);
        log.info("Citizen FIR deleted successfully: " + firId);
    }
}
