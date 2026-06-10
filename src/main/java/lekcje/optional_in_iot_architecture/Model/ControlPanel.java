package main.java.lekcje.optional_in_iot_architecture.Model;

import java.util.Optional;

public class ControlPanel {
    private Gateway gateway;

    public ControlPanel(Gateway gateway) {
        this.gateway = gateway;
    }

    public Optional<Gateway> getGateway() {
        return Optional.ofNullable(gateway);
    }
}
