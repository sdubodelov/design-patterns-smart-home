package com.sdubadzelau.smarthome.domain.devices;

import com.sdubadzelau.smarthome.domain.observer.Observable;

/**
 * Mediator pattern: Component class
 */
public class FrontDoor extends Observable {
    private boolean isOpen = false;

    public FrontDoor(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        this.isOpen = true;
        final String actionMessage = "[FrontDoor] open";
        System.out.println(actionMessage);
        notifyObservers(actionMessage);
    }

    public void close() {
        this.isOpen = false;
        final String actionMessage = "[FrontDoor] close";
        System.out.println(actionMessage);
        notifyObservers(actionMessage);
    }
}
