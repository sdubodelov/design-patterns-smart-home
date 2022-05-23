package com.sdubadzelau.smarthome.controller;

import com.sdubadzelau.smarthome.domain.devices.AlarmSystem;
import com.sdubadzelau.smarthome.domain.devices.FrontDoor;
import com.sdubadzelau.smarthome.domain.devices.Light;
import com.sdubadzelau.smarthome.domain.devices.coffeemaker.CoffeeMaker;
import com.sdubadzelau.smarthome.domain.devices.coffeemaker.StrongCoffeeCreationStrategy;
import com.sdubadzelau.smarthome.domain.devices.coffeemaker.WeakCoffeeCreationStrategy;
import com.sdubadzelau.smarthome.domain.devices.heatingsystem.HeatingSystem;
import com.sdubadzelau.smarthome.domain.devices.heatingsystem.LegacyHeatingSystem;
import com.sdubadzelau.smarthome.domain.observer.MessageObserver;

/**
 * Mediator Pattern: Mediator class
 * Command pattern: Receiver class (There is no invoker class in this project, it could be sensors,
 *                  but there is no such class here, commands are executed by Application class itself)
 */
public class HomeController {

    private CoffeeMaker coffeeMaker;
    private Light light;
    private HeatingSystem heatingSystem;
    private FrontDoor frontDoor;
    private AlarmSystem alarmSystem;

    private HomeController(HomeControllerBuilder homeControllerBuilder) {
        this.coffeeMaker = homeControllerBuilder.coffeeMaker;
        this.light = homeControllerBuilder.light;
        this.heatingSystem = homeControllerBuilder.heatingSystem;
        this.frontDoor = homeControllerBuilder.frontDoor;
        this.alarmSystem = homeControllerBuilder.alarmSystem;
    }

    public void onMovement() {
        if (!light.isTurnedOn()) {
            light.turnOn();
        }
        else {
            System.out.println("[HomeController] nothing to do (light is already turned on)");
        }

        if (alarmSystem.isTurnedOn()) {
            alarmSystem.alarm();
        }
    }
    public void onGoingHome(){
        if (!heatingSystem.isTurnedOn()) {
            heatingSystem.turnOn();
        }
        else {
            System.out.println("[HomeController] nothing to do (heating system is already turned on");
        }
    }
    public void onArriveHome(){
        if (alarmSystem.isTurnedOn()) {
            alarmSystem.turnOff();
        }
        else {
            System.out.println("[HomeController] nothing to do (alarm system is already turned off)");
        }

        if (!frontDoor.isOpen()) {
            frontDoor.open();
        }
        else {
            System.out.println("[HomeController] nothing to do (front door is already opened)");
        }

        coffeeMaker.createCoffee();
    }
    public void onChangeToHoliday(){
        coffeeMaker.setCoffeeCreationStrategy(WeakCoffeeCreationStrategy.getInstance());
    }
    public void onChangeToWorkingDay() {
        coffeeMaker.setCoffeeCreationStrategy(StrongCoffeeCreationStrategy.getInstance());
    }

    /**
     * Builder Pattern: Builder class
     */
    public static class HomeControllerBuilder {

        private CoffeeMaker coffeeMaker = new CoffeeMaker(StrongCoffeeCreationStrategy.getInstance());
        private Light light = new Light(false);
        private HeatingSystem heatingSystem = new HeatingSystem(new LegacyHeatingSystem(false));
        private FrontDoor frontDoor = new FrontDoor(false);
        private AlarmSystem alarmSystem = new AlarmSystem(false);
        private MessageObserver messageObserver;

        public HomeControllerBuilder(MessageObserver messageObserver) {
            this.messageObserver = messageObserver;

            alarmSystem.addObserver(messageObserver);
            coffeeMaker.addObserver(messageObserver);
            frontDoor.addObserver(messageObserver);
            heatingSystem.addObserver(messageObserver);
            light.addObserver(messageObserver);
        }

        public HomeControllerBuilder setCoffeeMaker(CoffeeMaker coffeeMaker) {
            this.coffeeMaker = coffeeMaker;
            return this;
        }

        public HomeControllerBuilder setLight(Light light) {
            this.light = light;
            return this;
        }

        public HomeControllerBuilder setHeatingSystem(HeatingSystem heatingSystem) {
            this.heatingSystem = heatingSystem;
            return this;
        }

        public HomeControllerBuilder setFrontDoor(FrontDoor frontDoor) {
            this.frontDoor = frontDoor;
            return this;
        }

        public HomeControllerBuilder setAlarmSystem(AlarmSystem alarmSystem) {
            this.alarmSystem = alarmSystem;
            return this;
        }

        public HomeController build() {
            return new HomeController(this);
        }
    }
}
