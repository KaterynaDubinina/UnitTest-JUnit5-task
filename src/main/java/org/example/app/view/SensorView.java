package org.example.app.view;

import org.example.app.utils.DNInputValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SensorView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getOption() {
        System.out.print("""
                
                \uD83D\uDDA5\uFE0F   Оберіть опцію:
                
                1\uFE0F\u20E3   Ввести показники
                0\uFE0F\u20E3   Закрити додаток
                
                """);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public static Map<String, String> getData() {
        System.out.print("\nВведіть своє ім'я: ");
        String operatorName = scanner.nextLine();

        String deviceNumber;
        do {
            System.out.print("\nВведіть номер пристрою у форматі DN-xxxx: ");
            deviceNumber = scanner.nextLine();
            if (!DNInputValidator.isDNValid(deviceNumber)) {
                System.out.println("\u274C Невірний формат номера пристрою");
            }
        } while (!DNInputValidator.isDNValid(deviceNumber));

        System.out.print("Введіть температуру у °C: ");
        String temp = scanner.nextLine();

        Map<String, String> deviceData = new HashMap<>();
        deviceData.put("operatorName", operatorName);
        deviceData.put("deviceNumber", deviceNumber);
        deviceData.put("temp", temp);

        return deviceData;
    }
}
