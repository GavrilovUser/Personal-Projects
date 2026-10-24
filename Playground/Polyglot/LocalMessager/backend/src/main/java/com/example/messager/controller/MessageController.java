package com.example.messager.controller;

import org.springframework.web.bind.annotation.*;

import com.example.messager.model.Message;
import com.example.messager.dto.message.MessageShortDto;
import com.example.messager.service.MessageService;

import com.example.messager.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/message")
public class MessageController {
  private final MessageService messageService;
  private final AccountService accountService;
  
  @PostMapping()
  public Message newMessage(@RequestBody MessageShortDto messageDto) {
    Message message = messageService.newMessage(messageDto.getAuthor(), messageDto.getContent());
    return message;
  }
}