package com.sdubadzelau.smarthome.commands;

import com.sdubadzelau.smarthome.controller.HomeController;

/**
 * Command Pattern: Concrete Command Class
 */
public class ChangeToWorkingDayEvent extends EventCommand {

    ChangeToWorkingDayEvent(HomeController homeController) {
        super(homeController);
    }

    @Override
    public void execute() {
        homeController.onChangeToWorkingDay();
    }
}
