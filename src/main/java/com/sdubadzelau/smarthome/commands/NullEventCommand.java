package com.sdubadzelau.smarthome.commands;

import com.sdubadzelau.smarthome.controller.HomeController;

public class NullEventCommand extends EventCommand {

    NullEventCommand(HomeController homeController) {
        super(homeController);
    }

    @Override
    public void execute() {
        System.out.println("Null event command execution");
    }
}
