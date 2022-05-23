package com.sdubadzelau.smarthome.commands;

import com.sdubadzelau.smarthome.controller.HomeController;

/**
 * Command Pattern: Concrete Command Class
 */
public class GoingHomeEvent extends EventCommand {

    GoingHomeEvent(HomeController homeController) {
        super(homeController);
    }

    @Override
    public void execute() {
        homeController.onGoingHome();
    }
}
