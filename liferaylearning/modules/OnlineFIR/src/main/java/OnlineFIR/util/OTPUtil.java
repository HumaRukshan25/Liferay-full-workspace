package OnlineFIR.util;

import javax.servlet.http.HttpSession;
import java.util.Random;

public class OTPUtil {

    // Get stored OTP from session
    public static String getStoredOTP(HttpSession session) {
        return (String) session.getAttribute("EXPECTED_OTP");
    }

    // Check if OTP challenge is active
    public static boolean isOTPChallengeActive(HttpSession session) {
        return session.getAttribute("OTP_CHALLENGE") != null
               && (Boolean) session.getAttribute("OTP_CHALLENGE");
    }

    // Validate entered OTP against stored OTP
    public static boolean validateOTP(HttpSession session, String enteredOTP) {
        String expectedOTP = getStoredOTP(session);
        return expectedOTP != null && expectedOTP.equals(enteredOTP);
    }

    // Clear OTP from session
    public static void clearOTP(HttpSession session) {
        session.removeAttribute("EXPECTED_OTP");
        session.removeAttribute("OTP_CHALLENGE");
        session.removeAttribute("OTP_USER_ID");
        session.removeAttribute("OTP_TIMESTAMP");
    }

    // Check if OTP has expired (5 minutes)
    public static boolean isOTPExpired(HttpSession session) {
        Long timestamp = (Long) session.getAttribute("OTP_TIMESTAMP");
        if (timestamp == null) return true;

        return (System.currentTimeMillis() - timestamp) > 300_000; // 5 minutes
    }

    // Generate new 6-digit OTP and store in session
    public static String generateOTP(HttpSession session) {
        Random random = new Random();
        String otpCode = String.format("%06d", random.nextInt(1_000_000)); // 000000 to 999999

        session.setAttribute("EXPECTED_OTP", otpCode);
        session.setAttribute("OTP_CHALLENGE", true);
        session.setAttribute("OTP_TIMESTAMP", System.currentTimeMillis());

        return otpCode;
    }
}
