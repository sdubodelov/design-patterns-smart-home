package com.sdubadzelau.smarthome.commands;

import com.sdubadzelau.smarthome.controller.HomeController;

/**
 * Command Pattern: Concrete Command Class
 */
public class ArrivesHomeEvent extends EventCommand {

    ArrivesHomeEvent(HomeController homeController) {
        super(homeController);
    }

    @Override
    public void execute() {
        homeController.onArriveHome();
    }
}
