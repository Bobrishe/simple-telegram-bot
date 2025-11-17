package com.alexki.simplejavabot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;

@Service
public class LongPollingService implements SpringLongPollingBot {

    private final UpdateConsumerService updateConsumer;
    private final String token;

    public LongPollingService(UpdateConsumerService updateConsumer, @Value("${telegram.bot.token}") String token) {
        this.updateConsumer = updateConsumer;
        this.token = token;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return updateConsumer;
    }
}
