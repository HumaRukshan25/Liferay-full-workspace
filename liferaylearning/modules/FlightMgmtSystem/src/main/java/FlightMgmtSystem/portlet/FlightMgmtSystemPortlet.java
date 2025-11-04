package FlightMgmtSystem.portlet;

import FlightMgmtSystem.constants.FlightMgmtSystemPortletKeys;
import FlightMgmtSystemService.service.FlightLocalService;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * @author Sania Mir
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FlightMgmtSystem",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FlightMgmtSystemPortletKeys.FLIGHTMGMTSYSTEM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FlightMgmtSystemPortlet extends MVCPortlet {
	
	 @Reference
	    private FlightLocalService _flightLocalService;

	 @ProcessAction(name="addFlight")
	 public void addFlight(ActionRequest actionRequest, ActionResponse actionResponse)
	         throws Exception {

	     ThemeDisplay themeDisplay =
	             (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

	     long userId = themeDisplay.getUserId();
	     long groupId = themeDisplay.getScopeGroupId();
	     long companyId = themeDisplay.getCompanyId();

	     String flightNumber = ParamUtil.getString(actionRequest, "flightNumber");
	     String airline = ParamUtil.getString(actionRequest, "airline");
	     String departureAirport = ParamUtil.getString(actionRequest, "departureAirport");
	     String arrivalAirport = ParamUtil.getString(actionRequest, "arrivalAirport");

	     Date departureTime = ParamUtil.getDate(
	             actionRequest, "departureTime", new SimpleDateFormat("yyyy-MM-dd"));

	     Date arrivalTime = ParamUtil.getDate(
	             actionRequest, "arrivalTime", new SimpleDateFormat("yyyy-MM-dd"));

	     int availableSeats = ParamUtil.getInteger(actionRequest, "availableSeats");
	     double price = ParamUtil.getDouble(actionRequest, "price");

	     // ✅ Save to DB
	     _flightLocalService.addFlight(
	             userId, groupId, companyId, flightNumber, airline,
	             departureAirport, arrivalAirport, departureTime, arrivalTime,
	             availableSeats, price
	     );
	 }
	 
	 
	 @ProcessAction(name = "deleteFlight")
	 public void deleteFlight(ActionRequest actionRequest, ActionResponse actionResponse)
	         throws Exception {

	     long flightId = ParamUtil.getLong(actionRequest, "flightId");

	     _flightLocalService.deleteFlight(flightId);
	 }

//	 @ProcessAction(name = "updateFlight")
//	 public void updateFlight(ActionRequest actionRequest, ActionResponse actionResponse)
//	         throws Exception {
//
//	     long flightId = ParamUtil.getLong(actionRequest, "flightId");
//
//	     String flightNumber = ParamUtil.getString(actionRequest, "flightNumber");
//	     String airline = ParamUtil.getString(actionRequest, "airline");
//	     String departureAirport = ParamUtil.getString(actionRequest, "departureAirport");
//	     String arrivalAirport = ParamUtil.getString(actionRequest, "arrivalAirport");
//	     int availableSeats = ParamUtil.getInteger(actionRequest, "availableSeats");
//	     double price = ParamUtil.getDouble(actionRequest, "price");
//
//	     _flightLocalService.updateFlight(
//	             flightId, flightNumber, airline, departureAirport,
//	             arrivalAirport, availableSeats, price
//	     );
//	 }
	 
	 
	 @ProcessAction(name = "updateFlight")
	 public void updateFlight(ActionRequest actionRequest, ActionResponse actionResponse)
	         throws Exception {

	     long flightId = ParamUtil.getLong(actionRequest, "flightId");

	     String flightNumber = ParamUtil.getString(actionRequest, "flightNumber");
	     String airline = ParamUtil.getString(actionRequest, "airline");
	     String departureAirport = ParamUtil.getString(actionRequest, "departureAirport");
	     String arrivalAirport = ParamUtil.getString(actionRequest, "arrivalAirport");

	     Date departureTime = ParamUtil.getDate(
	             actionRequest, "departureTime", new SimpleDateFormat("yyyy-MM-dd"));

	     Date arrivalTime = ParamUtil.getDate(
	             actionRequest, "arrivalTime", new SimpleDateFormat("yyyy-MM-dd"));

	     int availableSeats = ParamUtil.getInteger(actionRequest, "availableSeats");
	     double price = ParamUtil.getDouble(actionRequest, "price");

	     _flightLocalService.updateFlight(
	             flightId, flightNumber, airline, departureAirport,
	             arrivalAirport, departureTime, arrivalTime,
	             availableSeats, price
	     );
	 }



}