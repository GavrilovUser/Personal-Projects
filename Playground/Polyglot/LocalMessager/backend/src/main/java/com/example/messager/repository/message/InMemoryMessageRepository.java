package com.example.messager.repository.message;

import org.springframework.stereotype.Repository;

import com.example.messager.model.Message;

import com.example.messager.dto.account.AccountShortDto;

import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryMessageRepository implements MessageRepository {
  private final List<Message> messages = new ArrayList<>();
  private final AtomicLong ids = new AtomicLong(0);
  
  @Override
  public Message newMessage(AccountShortDto author, String content) {
    long messageId = ids.incrementAndGet();
    Message message = new Message(author, messageId, content);
    return message;
  }
}