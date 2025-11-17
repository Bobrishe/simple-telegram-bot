package com.alexki.simplejavabot.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

import java.util.*;

@Component
public class InlineMenu implements ChatMenu {

    @Override
    public InlineKeyboardMarkup createMenu() {

        List<InlineKeyboardRow> rows = new ArrayList<>();

        for(InlineOptions option: InlineOptions.values()) {

            InlineKeyboardButton button = InlineKeyboardButton.builder()
                    .text(option.text)
                    .callbackData(option.callback)
                    .build();

            InlineKeyboardRow row = new InlineKeyboardRow(button);

            rows.add(row);

        }

        return new InlineKeyboardMarkup(rows);
    }

}
