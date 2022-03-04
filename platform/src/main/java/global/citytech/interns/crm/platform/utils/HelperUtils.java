package global.citytech.interns.crm.platform.utils;

import java.util.UUID;

public class HelperUtils {
    public static String generateRandomId(){
        return UUID.randomUUID().toString();
    }

    public static boolean isBlankOrNull(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public static boolean notBlankOrNull(String str) {
        return !isBlankOrNull(str);
    }
}
