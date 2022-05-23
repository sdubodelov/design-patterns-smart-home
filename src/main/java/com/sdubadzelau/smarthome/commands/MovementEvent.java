package com.sdubadzelau.smarthome.commands;

import com.sdubadzelau.smarthome.controller.HomeController;

/**
 * Command Pattern: Concrete Command Class
 */
public class MovementEvent extends EventCommand {

    MovementEvent(HomeController homeController) {
        super(homeController);
    }

    @Override
    public void execute() {
        homeController.onMovement();
    }
}
