package com.alexki.simplejavabot.handler;

import com.alexki.simplejavabot.buttons.ButtonMenu;
import com.alexki.simplejavabot.buttons.InlineMenu;
import com.alexki.simplejavabot.service.MessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;

@Service
public class MessageHandler extends UpdateHandler {

    protected MessageHandler(MessageService messageService, InlineMenu inlineMenu, ButtonMenu buttonMenu) {
        super(messageService, inlineMenu, buttonMenu);
    }

    @Override
    public void handle(Update update) {
        Message message = update.getMessage();

        if (message != null && message.hasText()) {
            String text = message.getText();

            switch (text) {
                case "/start":
                    getMessageService().sendMessage(message, getInlineMenu().createMenu());
                    break;
                case "/help":
                    getMessageService().help(message.getChatId());
                    break;
                default:
                    getMessageService().sendMessage(message, getButtonMenu().createMenu());
            }
        }


    }
}
