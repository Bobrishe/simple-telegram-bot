package com.alexki.simplejavabot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;


@Service
public class MessageService {

    private final TelegramClient client;

    public MessageService(TelegramClient client) {
        this.client = client;
    }

    private SendMessage createSendMessage(Long chatId, String text) {
        return SendMessage.builder()
                .text(text)
                .chatId(chatId.toString())
                .build();
    }

    private SendMessage createSendMessage(Message message) {
        return SendMessage.builder()
                .text(message.getText())
                .chatId(message.getChatId().toString())
                .build();
    }

    private void execute(SendMessage sendMessage) {
        try {
            client.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(Long chatId, String text) {
        execute(createSendMessage(chatId, text));
    }

    public void sendMessage(Message message, ReplyKeyboard markup) {
        SendMessage sendMessage = createSendMessage(message);
        sendMessage.setReplyMarkup(markup);
        execute(sendMessage);
    }

    public void help(Long chatId) {
        String helpCommands = """
                /start - to start work with a bot
                /help - to get help menu
                """;

        sendMessage(chatId, helpCommands);
    }


}
