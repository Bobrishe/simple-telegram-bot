package com.alexki.simplejavabot.buttons;

public enum Buttons {
    START("/start"),
    MY_INFO("/help");

    public final String command;

    Buttons(String command) {
        this.command = command;
    }


}
