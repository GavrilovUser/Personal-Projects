package com.example.messager.dto.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import com.example.messager.dto.account.AccountShortDto;

@Getter
@RequiredArgsConstructor
public class MessageShortDto {
  private AccountShortDto author;
  private long id;
  private String content;
}