package com.alexki.simplejavabot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface ChatMenu {
    ReplyKeyboard createMenu();
}
