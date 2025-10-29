package OnlineFIRpolice.portlet;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import fironlineser.model.FIRRR;
import fironlineser.model.PoliceStation;
import fironlineser.service.FIRRRLocalServiceUtil;
import fironlineser.service.PoliceStationLocalServiceUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.util.*;

import OnlineFIRpolice.constants.OnlineFIRpolicePortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRpolicePortletKeys.ONLINEFIRPOLICE,
        "mvc.command.name=/police/viewAssignedFIRs"
    },
    service = MVCRenderCommand.class
)
public class ViewAssignedFIRsRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User loggedInUser = themeDisplay.getUser();
        String currentFullName = (loggedInUser.getFirstName() + " " + loggedInUser.getLastName()).trim();

        List<FIRRR> matchedFIRs = new ArrayList<>();
        List<User> inspectors = new ArrayList<>();

        try {
            long companyId = themeDisplay.getCompanyId();
            List<Role> userRoles = loggedInUser.getRoles();

            boolean isPolice = userRoles.stream().anyMatch(r -> r.getName().equalsIgnoreCase("Police"));
            boolean isInspector = userRoles.stream().anyMatch(r -> r.getName().equalsIgnoreCase("Inspector"));

            System.out.println("=== DEBUG INFO ===");
            System.out.println("Current User: " + currentFullName);
            System.out.println("Company ID: " + companyId);
            System.out.println("Is Police: " + isPolice);
            System.out.println("Is Inspector: " + isInspector);

            // ✅ Enhanced inspector fetching with better debugging
            inspectors = getInspectors(companyId);
            System.out.println("✅ Found " + inspectors.size() + " inspectors for dropdown");

            if (isPolice) {
                System.out.println("Processing as Police Officer");
                matchedFIRs = getFIRsForPoliceOfficer(currentFullName);
            } 
            else if (isInspector) {
                System.out.println("Processing as Inspector");
                matchedFIRs = getFIRsForInspector(currentFullName);
            }

            System.out.println("Matched FIRs count: " + matchedFIRs.size());
            System.out.println("=== END DEBUG ===");

            // ✅ SET BOTH ATTRIBUTES
            renderRequest.setAttribute("matchedFIRs", matchedFIRs);
            renderRequest.setAttribute("inspectors", inspectors);

        } catch (Exception e) {
            System.out.println("❌ ERROR in render: " + e.getMessage());
            e.printStackTrace();
            // Set empty lists to avoid JSP errors
            renderRequest.setAttribute("matchedFIRs", new ArrayList<>());
            renderRequest.setAttribute("inspectors", new ArrayList<>());
        }

        return "/viewAssignedFIRs.jsp";
    }

    private List<User> getInspectors(long companyId) {
        List<User> inspectors = new ArrayList<>();
        try {
            System.out.println("🔍 Looking for Inspector role...");
            
            // Try different possible role names
            String[] possibleRoleNames = {"Inspector", "inspector", "INSPECTOR"};
            Role inspectorRole = null;
            
            for (String roleName : possibleRoleNames) {
                try {
                    inspectorRole = RoleLocalServiceUtil.getRole(companyId, roleName);
                    if (inspectorRole != null) {
                        System.out.println("✅ Found role: " + roleName + " with ID: " + inspectorRole.getRoleId());
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("❌ Role '" + roleName + "' not found: " + e.getMessage());
                }
            }
            
            if (inspectorRole != null) {
                inspectors = UserLocalServiceUtil.getRoleUsers(inspectorRole.getRoleId());
                System.out.println("📊 Raw inspectors from service: " + inspectors.size());
                
                // Filter active users only
                List<User> activeInspectors = new ArrayList<>();
                for (User user : inspectors) {
                    if (user.isActive()) {
                        activeInspectors.add(user);
                        System.out.println("👮 Active Inspector: " + user.getFullName() + " (ID: " + user.getUserId() + ")");
                    }
                }
                
                inspectors = activeInspectors;
                System.out.println("✅ Final active inspectors: " + inspectors.size());
                
            } else {
                System.out.println("❌ No Inspector role found with any name variation");
                
                // Debug: List all available roles
                try {
                    List<Role> allRoles = RoleLocalServiceUtil.getRoles(companyId);
                    System.out.println("📋 All available roles:");
                    for (Role role : allRoles) {
                        System.out.println("   - " + role.getName() + " (ID: " + role.getRoleId() + ")");
                    }
                } catch (Exception e) {
                    System.out.println("❌ Could not list roles: " + e.getMessage());
                }
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error fetching inspectors: " + e.getMessage());
            e.printStackTrace();
        }
        return inspectors;
    }

    private List<FIRRR> getFIRsForPoliceOfficer(String currentFullName) throws Exception {
        List<FIRRR> matchedFIRs = new ArrayList<>();
        List<PoliceStation> stations = PoliceStationLocalServiceUtil.getPoliceStations(0, Integer.MAX_VALUE);
        Set<String> stationAddresses = new HashSet<>();

        System.out.println("🏢 Processing police stations for: " + currentFullName);
        
        for (PoliceStation station : stations) {
            if (station.getOfficerInCharge() != null &&
                station.getAddress() != null &&
                station.getOfficerInCharge().trim().equalsIgnoreCase(currentFullName)) {

                String normalizedAddr = normalize(station.getAddress());
                stationAddresses.add(normalizedAddr);
                System.out.println("📍 Station address matched: " + normalizedAddr);
            }
        }

        List<FIRRR> allFIRs = FIRRRLocalServiceUtil.getFIRRRs(0, Integer.MAX_VALUE);
        System.out.println("📄 Total FIRs in system: " + allFIRs.size());

        for (FIRRR fir : allFIRs) {
            if (fir.getIncidentLocation() != null) {
                String normalizedIncident = normalize(fir.getIncidentLocation());
                for (String addr : stationAddresses) {
                    if (normalizedIncident.equals(addr)) {
                        matchedFIRs.add(fir);
                        System.out.println("✅ FIR matched: " + fir.getFirId() + " - " + normalizedIncident);
                        break;
                    }
                }
            }
        }
        return matchedFIRs;
    }

    private List<FIRRR> getFIRsForInspector(String currentFullName) throws Exception {
        List<FIRRR> matchedFIRs = new ArrayList<>();
        List<FIRRR> allFIRs = FIRRRLocalServiceUtil.getFIRRRs(0, Integer.MAX_VALUE);

        System.out.println("🔍 Looking for FIRs assigned to: " + currentFullName);

        for (FIRRR fir : allFIRs) {
            if (fir.getAssignedInspector() != null &&
                fir.getAssignedInspector().trim().equalsIgnoreCase(currentFullName)) {
                matchedFIRs.add(fir);
                System.out.println("✅ FIR assigned to inspector: " + fir.getFirId());
            }
        }
        return matchedFIRs;
    }

    private String normalize(String text) {
        return text == null ? "" : text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().trim();
    }
}



