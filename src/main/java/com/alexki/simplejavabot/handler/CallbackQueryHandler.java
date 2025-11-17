package com.alexki.simplejavabot.handler;

import com.alexki.simplejavabot.buttons.ButtonMenu;
import com.alexki.simplejavabot.buttons.InlineMenu;
import com.alexki.simplejavabot.service.MessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

@Service
public class CallbackQueryHandler extends UpdateHandler {


    protected CallbackQueryHandler(MessageService messageService, InlineMenu inlineMenu, ButtonMenu buttonMenu) {
        super(messageService, inlineMenu, buttonMenu);
    }

    @Override
    public void handle(Update update) {
        CallbackQuery query = update.getCallbackQuery();
        String data = query.getData();
        User user = query.getFrom();


        switch (data) {
            case "/my_name":
                getMessageService().sendMessage(user.getId(), "You name is: " + user.getFirstName());
                break;
            case "/my_nick":
                getMessageService().sendMessage(user.getId(), "You nick is: " + user.getUserName());
                break;
            default:
                break;
        }
    }

}
