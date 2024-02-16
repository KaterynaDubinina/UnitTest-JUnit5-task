package org.example.app;

import org.example.app.controller.SensorController;

public class App {

    public static void main(String[] args) {
        SensorController controller = new SensorController();
        System.out.println("\n \uD83C\uDF21\uFE0F   " +
                "Цей додаток для контролю температури пристрою   \uD83C\uDF21\uFE0F");
        controller.runApp();
    }
}
