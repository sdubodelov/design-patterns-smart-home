package com.sdubadzelau.smarthome.domain.devices.heatingsystem;

public interface HeatingSystemAdapter {
    void turnOff();
    void turnOn();
    boolean isTurnedOn();
}
