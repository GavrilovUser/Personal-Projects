package com.example.messager.repository.message;

import com.example.messager.model.Message;

import com.example.messager.dto.account.AccountShortDto;

public interface MessageRepository {
  Message newMessage(AccountShortDto author, String content);
}