package com.sdubadzelau.smarthome.domain.devices.coffeemaker;

public class WeakCoffeeCreationStrategy implements CoffeeCreationStrategy {

    private static WeakCoffeeCreationStrategy instance = null;

    private final Integer CAFFEINE_IN_MG = 20;

    @Override
    public Integer getCaffeineInMg() {
        return CAFFEINE_IN_MG;
    }


    public static WeakCoffeeCreationStrategy getInstance() {
        if (instance == null) {
            instance = new WeakCoffeeCreationStrategy();
        }
        return instance;
    }
}
