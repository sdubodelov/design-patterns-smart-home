package com.sdubadzelau.smarthome.domain.devices.heatingsystem;

import com.sdubadzelau.smarthome.domain.observer.Observable;

/**
 * Mediator pattern: Component class
 */
public class HeatingSystem extends Observable implements HeatingSystemAdapter {

    private boolean isTurnedOn = false;

    private LegacyHeatingSystem legacyHeatingSystem;

    public HeatingSystem(LegacyHeatingSystem legacyHeatingSystem) {
        this.legacyHeatingSystem = legacyHeatingSystem;
    }

    @Override
    public void turnOff() {
        legacyHeatingSystem.operate(false);

        final String actionMessage = "[Heating System] turn off";
        System.out.println(actionMessage);
        notifyObservers(actionMessage);
    }

    @Override
    public void turnOn() {
        legacyHeatingSystem.operate(true);

        final String actionMessage = "[Heating System] turn on";
        System.out.println(actionMessage);
        notifyObservers(actionMessage);
    }

    @Override
    public boolean isTurnedOn() {
        return legacyHeatingSystem.isTurnedOn();
    }
}
