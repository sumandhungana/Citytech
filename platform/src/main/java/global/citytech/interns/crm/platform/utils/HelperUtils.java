package global.citytech.interns.crm.platform.utils;

import java.util.UUID;

public class HelperUtils {
    public static String generateRandomId(){
        return UUID.randomUUID().toString();
    }
}
