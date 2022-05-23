package com.sdubadzelau.smarthome.domain.devices;

import com.sdubadzelau.smarthome.domain.observer.Observable;

/**
 * Mediator pattern: Component class
 */
public class AlarmSystem extends Observable {

    private boolean isTurnedOn = false;

    public AlarmSystem(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOn() {
        isTurnedOn = true;
    }

    public void turnOff() {
        isTurnedOn = false;
    }

    public void alarm() {

    }
}
