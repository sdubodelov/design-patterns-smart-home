package com.sdubadzelau.smarthome;

import com.sdubadzelau.smarthome.commands.EventCommandFactory;
import com.sdubadzelau.smarthome.commands.EventCommandType;
import com.sdubadzelau.smarthome.controller.HomeController;
import com.sdubadzelau.smarthome.domain.observer.MessageObserver;

import java.util.Collection;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        MessageObserver messageObserver = new MessageObserver();
        HomeController homeController = new HomeController.HomeControllerBuilder(messageObserver).build();

        EventCommandFactory eventCommandFactory = new EventCommandFactory(homeController);
        eventCommandFactory.createEventCommand(EventCommandType.CHANGE_TO_HOLIDAY).execute();
        eventCommandFactory.createEventCommand(EventCommandType.GOING_HOME).execute();
        eventCommandFactory.createEventCommand(EventCommandType.MOVEMENT).execute();
        eventCommandFactory.createEventCommand(EventCommandType.ARRIVES_HOME).execute();
        eventCommandFactory.createEventCommand(EventCommandType.MOVEMENT).execute();
        eventCommandFactory.createEventCommand(EventCommandType.CHANGE_TO_WORKING_DAY).execute();
        eventCommandFactory.createEventCommand(EventCommandType.GOING_HOME).execute();
        eventCommandFactory.createEventCommand(EventCommandType.ARRIVES_HOME).execute();
        eventCommandFactory.createEventCommand(EventCommandType.MOVEMENT).execute();

        System.out.println("\n\rall messages dispatched by the devices:");
        Optional.ofNullable(messageObserver.getMessages()).stream()
                .flatMap(Collection::stream).forEach(System.out::println);
    }
}
