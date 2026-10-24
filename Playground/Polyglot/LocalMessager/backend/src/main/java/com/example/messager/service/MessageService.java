package com.example.messager.service;

import org.springframework.stereotype.Service;

import com.example.messager.model.Message;

import com.example.messager.dto.account.AccountShortDto;

import com.example.messager.repository.message.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
  private final MessageRepository messageRepository;

  public Message newMessage(AccountShortDto author, String content) {
    Message message = messageRepository.newMessage(author, content);
    return message;
  }
}