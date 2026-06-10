package main.java.lekcje.optional_in_iot_architecture.Service;

import main.java.lekcje.optional_in_iot_architecture.Model.Building;
import main.java.lekcje.optional_in_iot_architecture.Model.ControlPanel;
import main.java.lekcje.optional_in_iot_architecture.Model.Gateway;

import java.util.Optional;

public class DiagnosticService {
    public void checkFirmwareStatus(Building building) {
        Optional.ofNullable(building)
                .flatMap(Building::getControlPanel)
                .flatMap(ControlPanel::getGateway)
                .flatMap(Gateway::getFirmwareVersion)
                    .filter(version -> !version.isBlank() && version.startsWith("v2."))
                    .or(() -> {
                    String defaultConfigTemplate = "v2.0.0-LTS";
                    return Optional.ofNullable(defaultConfigTemplate);
                    })
                    .ifPresentOrElse(
                        version -> System.out.println("Wykryta wersja oprogramowania: " + version),
                        () -> { throw new IllegalStateException("Błąd krytyczny diagnostyki systemu"); }
                    );
    }
}
