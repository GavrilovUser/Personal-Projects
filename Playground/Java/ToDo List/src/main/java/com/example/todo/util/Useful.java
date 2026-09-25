package com.example.todo.util;

import java.util.ArrayList;

import com.example.todo.service.TaskService;
import com.example.todo.entity.Task;

public class Useful {
  public static void createManyTasks(int count, TaskService taskService) {
    for (int index = 0; index < count; index++) {
      Task task = taskService.newTask("");
      task.content = "Задача #" + task.id;
    }
  }
}