package com.sdubadzelau.smarthome.domain.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Observable {
    private List<Observer> observers;

    public void addObserver(Observer observer) {
        if (observers != null) {
            observers.add(observer);
        } else {
            synchronized (this) {
                observers = new ArrayList<>();
                observers.add(observer);
            }
        }
    }

    public void notifyObservers(String message) {
        Optional.ofNullable(observers).stream()
                .flatMap(Collection::stream)
                .forEach(obs -> obs.update(message));
    }
}
