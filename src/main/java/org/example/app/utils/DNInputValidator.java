package org.example.app.utils;

public class DNInputValidator {

    public final static String DN_RGX = "^DN-[0-9]{4}$";

    public static boolean isDNValid(String deviceNumber) {
        if (deviceNumber != null) {
            return deviceNumber.matches(DN_RGX);
        }
        return false;
    }
}
