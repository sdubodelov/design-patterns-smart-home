package com.sdubadzelau.smarthome.domain.devices.coffeemaker;

public class StrongCoffeeCreationStrategy implements CoffeeCreationStrategy {

    private static StrongCoffeeCreationStrategy instance = null;

    private final Integer CAFFEINE_IN_MG = 40;

    @Override
    public Integer getCaffeineInMg() {
        return CAFFEINE_IN_MG;
    }

    public static StrongCoffeeCreationStrategy getInstance() {
        if (instance == null) {
            instance = new StrongCoffeeCreationStrategy();
        }
        return instance;
    }
}
