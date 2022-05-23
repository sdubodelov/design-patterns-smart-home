package com.sdubadzelau.smarthome.domain.observer;

import java.util.ArrayList;

public class MessageObserver implements Observer{

    private ArrayList<String> messages = new ArrayList<>();

    @Override
    public void update(String message) {
        if (message != null) {
            messages.add(message);
        }
    }

    public ArrayList<String> getMessages(){
        return messages;
    }
}
