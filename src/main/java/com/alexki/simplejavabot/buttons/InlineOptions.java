package com.alexki.simplejavabot.buttons;

public enum InlineOptions {
    MY_NAME("/my_name", "Get your name"),
    MY_NICK("/my_nick", "Get your Nickname");

    public final String callback;
    public final String text;

    InlineOptions(String callback, String text) {
        this.callback = callback;
        this.text = text;
    }
}
