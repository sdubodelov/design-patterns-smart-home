package com.sdubadzelau.smarthome.commands;

import com.sdubadzelau.smarthome.controller.HomeController;

/**
 * Command Pattern: Command Class
 */
public abstract class EventCommand {

    // Command Pattern: this filed is receiver
    protected HomeController homeController;

    EventCommand(HomeController homeController) {
        this.homeController = homeController;
    }

    public abstract void execute();

    public HomeController getHomeController() {
        return homeController;
    }
}
