package com.sdubadzelau.smarthome.commands;

import com.sdubadzelau.smarthome.controller.HomeController;

public class EventCommandFactory {

    private HomeController homeController;

    public EventCommandFactory(HomeController homeController) {
        this.homeController = homeController;
    }

    public EventCommand createEventCommand(EventCommandType eventCommandType) {

        if (EventCommandType.GOING_HOME.equals(eventCommandType)) {
           return new GoingHomeEvent(homeController);
        }
        if (EventCommandType.ARRIVES_HOME.equals(eventCommandType)) {
            return new ArrivesHomeEvent(homeController);
        }
        if (EventCommandType.MOVEMENT.equals(eventCommandType)) {
            return new MovementEvent(homeController);
        }
        if (EventCommandType.CHANGE_TO_HOLIDAY.equals(eventCommandType)) {
            return new ChangeToHolidayEvent(homeController);
        }
        if (EventCommandType.CHANGE_TO_WORKING_DAY.equals(eventCommandType)) {
            return new ChangeToWorkingDayEvent(homeController);
        }
        return new NullEventCommand(homeController);
    }
}
