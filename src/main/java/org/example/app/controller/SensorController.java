package org.example.app.controller;

import org.example.app.entity.Device;
import org.example.app.entity.Operator;
import org.example.app.exception.TempException;
import org.example.app.utils.AppValidator;
import org.example.app.view.SensorView;

import java.util.Map;

public class SensorController {

    public void runApp() {
        int option;
        do {
            option = SensorView.getOption();
            switch (option) {
                case 1 -> {
                    Map<String, String> data = SensorView.getData();
                    Operator operator = getOperator(data);
                    Device device = getDevice(data);

                    System.out.printf("\nОператор: %s\n", operator.getOperatorName());

                    try {
                        String result = AppValidator.validateTemperature(device);
                        System.out.println(result);
                    } catch (TempException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 0 -> System.out.println("\u274E Додаток вимкнено");
                default -> System.out.println("\u274C   Невірна опція \n\u2B07\uFE0F   Спробуйте ще");
            }
        } while (option != 0);
        System.exit(0);
    }

    private static Operator getOperator(Map<String, String> data) {
        return new Operator(data.get("operatorName"));
    }

    private static Device getDevice(Map<String, String> data) {
        return new Device(data.get("deviceNumber"), Integer.parseInt(data.get("temp")));
    }
}