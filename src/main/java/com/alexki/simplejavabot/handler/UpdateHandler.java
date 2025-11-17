package com.alexki.simplejavabot.handler;

import com.alexki.simplejavabot.buttons.ButtonMenu;
import com.alexki.simplejavabot.buttons.InlineMenu;
import com.alexki.simplejavabot.service.MessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class UpdateHandler {

    private final MessageService messageService;
    private final InlineMenu inlineMenu;
    private final ButtonMenu buttonMenu;

    protected UpdateHandler(MessageService messageService, InlineMenu inlineMenu, ButtonMenu buttonMenu) {
        this.messageService = messageService;
        this.inlineMenu = inlineMenu;
        this.buttonMenu = buttonMenu;
    }

    public abstract void handle(Update update);

    public MessageService getMessageService() {
        return messageService;
    }
    public ButtonMenu getButtonMenu() {
        return buttonMenu;
    }

    public InlineMenu getInlineMenu() {
        return inlineMenu;
    }

}
