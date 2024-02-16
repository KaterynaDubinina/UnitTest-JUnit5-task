package org.example.app.utils;

import org.example.app.entity.Device;
import org.example.app.exception.TempException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppValidatorTest {

    AppValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AppValidator();
    }

    @Test
    @DisplayName("Test if valid temperature is in the limits.")
    void test_If_Temp_Is_In_Limits() throws TempException {
        Device device = new Device("DN-4321", 22);
        assertEquals("\nПристрій: " + device.getDeviceNumber()
                + "\nТемпература: " + device.getTemp() + "°C"
                + "\nІндикатор: \uD83D\uDFE2"
                + "\n\nЗаключення: температура в допустимих межах",
                AppValidator.validateTemperature(device));
    }


    @Test
    @DisplayName("Test if invalid temperature throws exception.")
    void test_If_Invalid_Temp_Throws_Exception() {
        Device device = new Device("DN-1234", 40);
        assertThrows(TempException.class, () ->
                AppValidator.validateTemperature(device), "No exception.");
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }
}