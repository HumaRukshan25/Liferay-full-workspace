//package OnlineFIR.portlet.sync;
//
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//
//import fironlineser.model.SignupUser;
//import fironlineser.service.SignupUserLocalServiceUtil;
//
//import org.osgi.service.component.annotations.Activate;
//import org.osgi.service.component.annotations.Component;
//
//import java.util.List;
//
//@Component(
//    immediate = true,
//    service = AutoUserSync.class
//)
//public class AutoUserSync {
//
//    @Activate
//    public void activate() {
//        syncUsers();
//    }
//
//    private void syncUsers() {
//        try {
//            List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
//
//            for (User user : users) {
//                // Check if user already exists in SignupUser to avoid duplicates
//                SignupUser existing = SignupUserLocalServiceUtil.fetchSignupUser(user.getUserId());
//                if (existing != null) {
//                    continue;
//                }
//
//                long signupUserId = CounterLocalServiceUtil.increment(SignupUser.class.getName());
//                SignupUser signupUser = SignupUserLocalServiceUtil.createSignupUser(signupUserId);
//
//                signupUser.setSignupUserId(user.getUserId());
//                signupUser.setFirstName(user.getFirstName());
//                signupUser.setLastName(user.getLastName());
//                signupUser.setEmail(user.getEmailAddress());
//                signupUser.setLoginName(user.getScreenName());
//                    // Add phone number
//                signupUser.setPassword_(user.getPassword());         // Add password (hashed)
//
//                SignupUserLocalServiceUtil.addSignupUser(signupUser);
//            }
//
//            System.out.println("User sync to SignupUser table completed!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}



package OnlineFIR.portlet.sync;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import fironlineser.model.SignupUser;
import fironlineser.service.SignupUserLocalServiceUtil;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.List;

@Component(
    immediate = true,
    service = AutoUserSync.class
)
public class AutoUserSync {

    @Activate
    public void activate() {
        syncUsers();
    }

    private void syncUsers() {
        try {
            List<User> users = UserLocalServiceUtil.getUsers(-1, -1);

            for (User user : users) {
                // Avoid duplicates: assumes SignupUser has a finder or primary keyed by userId
                SignupUser existing = SignupUserLocalServiceUtil.fetchSignupUser(user.getUserId());
                if (existing != null) {
                    continue;
                }

                long signupUserId = CounterLocalServiceUtil.increment(SignupUser.class.getName());
                SignupUser signupUser = SignupUserLocalServiceUtil.createSignupUser(signupUserId);

                signupUser.setSignupUserId(user.getUserId());
                signupUser.setFirstName(user.getFirstName());
                signupUser.setLastName(user.getLastName());
                signupUser.setEmail(user.getEmailAddress());
                signupUser.setLoginName(user.getScreenName());
                //signupUser.setPhone(user.getPhones());

                // --- Get the hashed/encrypted password value (as stored in user_ table) ---
                String hashedPassword = user.getPassword(); // this is the stored hashed/encrypted value
                if (hashedPassword == null) {
                    hashedPassword = ""; // or handle appropriately
                }
                signupUser.setPassword_(hashedPassword); // store only the hashed value

                SignupUserLocalServiceUtil.addSignupUser(signupUser);
            }

            System.out.println("User sync to SignupUser table completed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
