package main.java.lekcje.optional_in_iot_architecture.model;

import java.util.Optional;

public class Gateway {
    private String firmwareVersion;

    public Gateway(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public Optional<String> getFirmwareVersion() {
        return Optional.ofNullable(firmwareVersion);
    }
}
