package com.example.messager.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import com.example.messager.dto.account.AccountShortDto;

@Getter
@RequiredArgsConstructor
public class Message {
  private final AccountShortDto author;
  private final long id;
  private final String content;
}