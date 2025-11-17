package com.alexki.simplejavabot.service;

import com.alexki.simplejavabot.handler.CallbackQueryHandler;
import com.alexki.simplejavabot.handler.MessageHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class UpdateConsumerService implements LongPollingSingleThreadUpdateConsumer {

    private final CallbackQueryHandler queryHandler;
    private final MessageHandler messageHandler;

    public UpdateConsumerService(CallbackQueryHandler queryHandler, MessageHandler messageHandler) {
        this.queryHandler = queryHandler;
        this.messageHandler = messageHandler;
    }

    @Override
    public void consume(Update update) {

        if (update.hasMessage()) {

            messageHandler.handle(update);

        } else if (update.hasCallbackQuery()) {
            queryHandler.handle(update);
        }
    }


}
