package org.example.app.utils;

import org.example.app.entity.Device;
import org.example.app.exception.TempException;

public class AppValidator {

    private static final int TEMP_LOWER_LIMIT = -10;
    private static final int TEMP_UPPER_LIMIT = 35;

    public static String validateTemperature(Device device) throws TempException {
        if (device.getTemp() >= TEMP_LOWER_LIMIT && device.getTemp() <= TEMP_UPPER_LIMIT) {
            return "\nПристрій: " + device.getDeviceNumber()
                    + "\nТемпература: " + device.getTemp() + "°C"
                    + "\nІндикатор: \uD83D\uDFE2"
                    + "\n\nЗаключення: температура в допустимих межах";
        } else {
            throw new TempException("\nПристрій: " + device.getDeviceNumber()
                    + "\nТемпература: " + device.getTemp() + "°C"
                    + "\nІндикатор: \uD83D\uDD34"
                    + "\n\nЗаключення: температура поза допустимими межами");
        }
    }
}