//package FlightMgmtForRestajax.portlet;
//
//import FlightMgmtForRestajax.constants.FlightMgmtForRestajaxPortletKeys;
//
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//
//import javax.portlet.Portlet;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * @author Sania Mir
// */
//@Component(
//	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.header-portlet-css=/css/main.css",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=FlightMgmtForRestajax",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/view.jsp",
//		"javax.portlet.name=" + FlightMgmtForRestajaxPortletKeys.FLIGHTMGMTFORRESTAJAX,
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user"
//	},
//	service = Portlet.class
//)
//public class FlightMgmtForRestajaxPortlet extends MVCPortlet {
//}




//package FlightMgmtForRestajax.portlet;
//
//import FlightMgmtForRestajax.constants.FlightMgmtForRestajaxPortletKeys;
//
//
//import com.liferay.portal.kernel.json.JSONFactoryUtil;
//import com.liferay.portal.kernel.json.JSONObject;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
//
//import com.liferay.portal.kernel.util.PortalUtil;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import javax.portlet.Portlet;
//import javax.portlet.PortletException;
//
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * @author Sania Mir
// */
//@Component(
//	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.header-portlet-css=/css/main.css",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=FlightMgmtForRestajax",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/view.jsp",
//		"javax.portlet.name=" + FlightMgmtForRestajaxPortletKeys.FLIGHTMGMTFORRESTAJAX,
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user"
//	},
//	service = Portlet.class
//)
//public class FlightMgmtForRestajaxPortlet extends MVCPortlet {
//	
//	@Override
//    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
//            throws IOException, PortletException {
//
//        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
//        String csrfToken = AuthTokenUtil.getToken(httpRequest);
//
//        String apiUrl = PortalUtil.getPortalURL(resourceRequest) + "/o/Flightheadlessapirest/v1.0/flights";
//        
//        try {
//            URL url = new URL(apiUrl);
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//            con.setRequestMethod("GET");
//            con.setRequestProperty("accept", "application/json");
//            con.setRequestProperty("x-csrf-token", csrfToken);
//            con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));
//
//            int responseCode = con.getResponseCode();
//            StringBuilder response = new StringBuilder();
//
//            try (BufferedReader in = new BufferedReader(new InputStreamReader(
//                    responseCode == 200 ? con.getInputStream() : con.getErrorStream()))) {
//                String line;
//                while ((line = in.readLine()) != null) {
//                    response.append(line);
//                }
//            }
//
//            // Write response back to AJAX
//            resourceResponse.setContentType("application/json");
//            resourceResponse.getWriter().write(response.toString());
//            
//        } catch (Exception e) {
//            JSONObject errorResponse = JSONFactoryUtil.createJSONObject();
//            errorResponse.put("error", "Failed to load flights: " + e.getMessage());
//            resourceResponse.getWriter().write(errorResponse.toString());
//        }
//    }
//}

package FlightMgmtForRestajax.portlet;

import FlightMgmtForRestajax.constants.FlightMgmtForRestajaxPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sania Mir
 */
@Component(
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=FlightMgmtForRestajax",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + FlightMgmtForRestajaxPortletKeys.FLIGHTMGMTFORRESTAJAX,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class FlightMgmtForRestajaxPortlet extends MVCPortlet {
    
    // Add this method to handle navigation to add-flight.jsp
    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        
        // Get the mvcPath parameter to determine which JSP to show
        String mvcPath = ParamUtil.getString(renderRequest, "mvcPath", "/view.jsp");
        
        // Include the appropriate JSP based on the mvcPath parameter
        include(mvcPath, renderRequest, renderResponse);
    }
    
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException, PortletException {

        String method = ParamUtil.getString(resourceRequest, "method", "GET");
        
        if ("POST".equalsIgnoreCase(method)) {
            handlePostFlight(resourceRequest, resourceResponse);
        } else {
            handleGetFlights(resourceRequest, resourceResponse);
        }
    }
    
    private void handleGetFlights(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
            throws IOException {
        
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        String csrfToken = AuthTokenUtil.getToken(httpRequest);

        String apiUrl = PortalUtil.getPortalURL(resourceRequest) + "/o/Flightheadlessapirest/v1.0/flights";
        
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("accept", "application/json");
            con.setRequestProperty("x-csrf-token", csrfToken);
            con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));

            int responseCode = con.getResponseCode();
            StringBuilder response = new StringBuilder();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    responseCode == 200 ? con.getInputStream() : con.getErrorStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            resourceResponse.setContentType("application/json");
            resourceResponse.getWriter().write(response.toString());
            
        } catch (Exception e) {
            JSONObject errorResponse = JSONFactoryUtil.createJSONObject();
            errorResponse.put("error", "Failed to load flights: " + e.getMessage());
            resourceResponse.getWriter().write(errorResponse.toString());
        }
    }
    
    private void handlePostFlight(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
            throws IOException {
        
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        String csrfToken = AuthTokenUtil.getToken(httpRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        String apiUrl = PortalUtil.getPortalURL(resourceRequest) + "/o/Flightheadlessapirest/v1.0/flights";
        
        try {
            // Get flight data from request
            String flightNumber = ParamUtil.getString(resourceRequest, "flightNumber");
            String airline = ParamUtil.getString(resourceRequest, "airline");
            String departureAirport = ParamUtil.getString(resourceRequest, "departureAirport");
            String arrivalAirport = ParamUtil.getString(resourceRequest, "arrivalAirport");
            int availableSeats = ParamUtil.getInteger(resourceRequest, "availableSeats");
            double price = ParamUtil.getDouble(resourceRequest, "price");

            // Create JSON payload
            JSONObject flightJson = JSONFactoryUtil.createJSONObject();
            flightJson.put("flightNumber", flightNumber);
            flightJson.put("airline", airline);
            flightJson.put("departureAirport", departureAirport);
            flightJson.put("arrivalAirport", arrivalAirport);
            flightJson.put("availableSeats", availableSeats);
            flightJson.put("price", price);

            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("accept", "application/json");
            con.setRequestProperty("x-csrf-token", csrfToken);
            con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));
            con.setDoOutput(true);

            // Write JSON data
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = flightJson.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();
            StringBuilder response = new StringBuilder();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    responseCode == 200 || responseCode == 201 ? con.getInputStream() : con.getErrorStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONObject result = JSONFactoryUtil.createJSONObject();
            if (responseCode == 200 || responseCode == 201) {
                result.put("success", true);
                result.put("message", "Flight added successfully!");
            } else {
                result.put("success", false);
                result.put("message", "Failed to add flight: " + response.toString());
            }
            
            resourceResponse.setContentType("application/json");
            resourceResponse.getWriter().write(result.toString());
            
        } catch (Exception e) {
            JSONObject errorResponse = JSONFactoryUtil.createJSONObject();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to add flight: " + e.getMessage());
            resourceResponse.getWriter().write(errorResponse.toString());
        }
    }
    
    private void handleDeleteFlight(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
            throws IOException {
        
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        String csrfToken = AuthTokenUtil.getToken(httpRequest);

        // Get flightId as Long (numeric)
        Long flightId = ParamUtil.getLong(resourceRequest, "flightId");
        String apiUrl = PortalUtil.getPortalURL(resourceRequest) + "/o/Flightheadlessapirest/v1.0/flights/" + flightId;
        
        System.out.println("Delete API URL: " + apiUrl);
        System.out.println("Flight ID to delete: " + flightId);
        
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("DELETE");
            con.setRequestProperty("accept", "application/json");
            con.setRequestProperty("x-csrf-token", csrfToken);
            con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));

            int responseCode = con.getResponseCode();
            System.out.println("Delete Response Code: " + responseCode);
            
            StringBuilder response = new StringBuilder();

            InputStream responseStream = (responseCode == 200 || responseCode == 204) 
                ? con.getInputStream() 
                : con.getErrorStream();
                
            if (responseStream != null) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(responseStream))) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        response.append(line);
                    }
                }
            }

            System.out.println("Delete Response: " + response.toString());

            JSONObject result = JSONFactoryUtil.createJSONObject();
            if (responseCode == 200 || responseCode == 204) {
                result.put("success", true);
                result.put("message", "Flight deleted successfully!");
            } else {
                result.put("success", false);
                result.put("message", "Failed to delete flight. Status: " + responseCode);
                if (response.length() > 0) {
                    result.put("details", response.toString());
                }
            }
            
            resourceResponse.setContentType("application/json");
            resourceResponse.getWriter().write(result.toString());
            
        } catch (Exception e) {
            System.out.println("Delete Exception: " + e.getMessage());
            e.printStackTrace();
            
            JSONObject errorResponse = JSONFactoryUtil.createJSONObject();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to delete flight: " + e.getMessage());
            resourceResponse.getWriter().write(errorResponse.toString());
        }
    }
    
    private void handlePutFlight(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
            throws IOException {
        
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        String csrfToken = AuthTokenUtil.getToken(httpRequest);

        Long flightId = ParamUtil.getLong(resourceRequest, "flightId");
        String apiUrl = PortalUtil.getPortalURL(resourceRequest) + "/o/Flightheadlessapirest/v1.0/flights/" + flightId;
        
        System.out.println("Update API URL: " + apiUrl);
        System.out.println("Flight ID to update: " + flightId);
        
        try {
            // Get flight data from request
            String flightNumber = ParamUtil.getString(resourceRequest, "flightNumber");
            String airline = ParamUtil.getString(resourceRequest, "airline");
            String departureAirport = ParamUtil.getString(resourceRequest, "departureAirport");
            String arrivalAirport = ParamUtil.getString(resourceRequest, "arrivalAirport");
            int availableSeats = ParamUtil.getInteger(resourceRequest, "availableSeats");
            double price = ParamUtil.getDouble(resourceRequest, "price");

            // Create JSON payload
            JSONObject flightJson = JSONFactoryUtil.createJSONObject();
            flightJson.put("flightNumber", flightNumber);
            flightJson.put("airline", airline);
            flightJson.put("departureAirport", departureAirport);
            flightJson.put("arrivalAirport", arrivalAirport);
            flightJson.put("availableSeats", availableSeats);
            flightJson.put("price", price);
            flightJson.put("flightId", flightId);

            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("accept", "application/json");
            con.setRequestProperty("x-csrf-token", csrfToken);
            con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));
            con.setDoOutput(true);

            // Write JSON data
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = flightJson.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();
            System.out.println("Update Response Code: " + responseCode);
            
            StringBuilder response = new StringBuilder();

            InputStream responseStream = (responseCode == 200 || responseCode == 204) 
                ? con.getInputStream() 
                : con.getErrorStream();
                
            if (responseStream != null) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(responseStream))) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        response.append(line);
                    }
                }
            }

            System.out.println("Update Response: " + response.toString());

            JSONObject result = JSONFactoryUtil.createJSONObject();
            if (responseCode == 200 || responseCode == 204) {
                result.put("success", true);
                result.put("message", "Flight updated successfully!");
            } else {
                result.put("success", false);
                result.put("message", "Failed to update flight. Status: " + responseCode);
                if (response.length() > 0) {
                    result.put("details", response.toString());
                }
            }
            
            resourceResponse.setContentType("application/json");
            resourceResponse.getWriter().write(result.toString());
            
        } catch (Exception e) {
            System.out.println("Update Exception: " + e.getMessage());
            e.printStackTrace();
            
            JSONObject errorResponse = JSONFactoryUtil.createJSONObject();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to update flight: " + e.getMessage());
            resourceResponse.getWriter().write(errorResponse.toString());
        }
    }
    
}