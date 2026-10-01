package com.example.bot.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import io.github.cdimascio.dotenv.Dotenv;

public class BotService extends TelegramLongPollingBot {
  private final Dotenv dotenv = Dotenv.load();
  
  @Override
  public String getBotUsername() {
    return dotenv.get("BOT_USERNAME");
  }

  @Override
  public String getBotToken() {
    return dotenv.get("BOT_TOKEN");
  }

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      String messageText = update.getMessage().getText();
      long chatId = update.getMessage().getChatId();

      SendMessage replyMessage = new SendMessage();
      replyMessage.setChatId(chatId);
      replyMessage.setText(messageText);

      try {
        execute(replyMessage);
      } catch (TelegramApiException error) {
        error.printStackTrace();
      }
    }
  }
}