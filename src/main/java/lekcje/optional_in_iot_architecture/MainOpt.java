package main.java.lekcje.optional_in_iot_architecture;

import main.java.lekcje.optional_in_iot_architecture.model.Building;
import main.java.lekcje.optional_in_iot_architecture.model.ControlPanel;
import main.java.lekcje.optional_in_iot_architecture.model.Gateway;
import main.java.lekcje.optional_in_iot_architecture.service.DiagnosticService;

public class MainOpt {
    public static void main(String[] args) {
        DiagnosticService service = new DiagnosticService();


        Gateway gateway1 = new Gateway("v2.1.4");
        ControlPanel panel1 = new ControlPanel(gateway1);
        Building building1 = new Building(panel1);
        service.checkFirmwareStatus(building1);


        Gateway gateway2 = new Gateway("v1.0.5");
        ControlPanel panel2 = new ControlPanel(gateway2);
        Building building2 = new Building(panel2);
        service.checkFirmwareStatus(building2);


        ControlPanel panel3 = new ControlPanel(null);
        Building building3 = new Building(panel3);
        service.checkFirmwareStatus(building3);
        // Oczekiwany wynik: v2.0.0-LTS (domyślna)

        service.checkFirmwareStatus(null);


        Gateway gateway5 = new Gateway("   ");
        ControlPanel panel5 = new ControlPanel(gateway5);
        Building building5 = new Building(panel5);
        service.checkFirmwareStatus(building5);

    }
}
