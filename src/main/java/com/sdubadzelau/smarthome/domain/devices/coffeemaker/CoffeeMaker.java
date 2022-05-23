package com.sdubadzelau.smarthome.domain.devices.coffeemaker;

import com.sdubadzelau.smarthome.domain.observer.Observable;

/**
 * Mediator pattern: Component class
 */
public class CoffeeMaker extends Observable {

    private CoffeeCreationStrategy coffeeCreationStrategy;

    public CoffeeMaker(CoffeeCreationStrategy coffeeCreationStrategy) {
        this.coffeeCreationStrategy = coffeeCreationStrategy;
    }

    public void setCoffeeCreationStrategy(CoffeeCreationStrategy coffeeCreationStrategy) {
        this.coffeeCreationStrategy = coffeeCreationStrategy;
        final String actionMessage = "[Coffee maker] change the type of the coffee";
        System.out.println(actionMessage);
        notifyObservers(actionMessage);
    }

    public void createCoffee() {
        final String actionMessage = String.format("[CoffeeMaker] create coffee with %smg caffeine", coffeeCreationStrategy.getCaffeineInMg());
        System.out.println(actionMessage);
        notifyObservers(actionMessage);
    }
}
