package main.java.lekcje.optional_in_iot_architecture.model;

import java.util.Optional;

public class Building {
    private ControlPanel controlPanel;

    public Building(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public Optional<ControlPanel> getControlPanel() {
        return Optional.ofNullable(controlPanel);
    }
}