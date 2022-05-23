package com.sdubadzelau.smarthome.domain.devices;

import com.sdubadzelau.smarthome.controller.HomeController;
import com.sdubadzelau.smarthome.domain.observer.Observable;

/**
 * Mediator pattern: Component class
 */
public class Light extends Observable {

    HomeController homeController;

    private boolean isTurnedOn = false;

    public Light(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOn() {
        isTurnedOn = true;
        final String actionMessage = "[Light] turn on";
        System.out.println(actionMessage);
        notifyObservers(actionMessage);
    }

    public void turnOff() {
        isTurnedOn = false;
        final String actionMessage = "[Light] turn off";
        System.out.println(actionMessage);
        notifyObservers(actionMessage);
    }
}
