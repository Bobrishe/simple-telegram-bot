package com.alexki.simplejavabot.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.*;

@Component
public class ButtonMenu implements ChatMenu {

    @Override
    public ReplyKeyboardMarkup createMenu() {

        List<KeyboardRow> buttons = new ArrayList<>();

        for (Buttons button : Buttons.values()) {
            KeyboardRow buttonCommand = new KeyboardRow(button.command);
            buttons.add(buttonCommand);
        }

        return new ReplyKeyboardMarkup(buttons);
    }

}
