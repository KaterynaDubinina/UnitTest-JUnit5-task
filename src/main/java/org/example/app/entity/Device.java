package org.example.app.entity;

public class Device {

    private final String deviceNumber;
    private final int temp;

    public Device(String deviceNumber, int temp) {
        this.deviceNumber = deviceNumber;
        this.temp = temp;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public int getTemp() {
        return temp;
    }
}
