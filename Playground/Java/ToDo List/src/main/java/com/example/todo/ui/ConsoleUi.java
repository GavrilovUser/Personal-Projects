package com.example.todo.ui;

import java.util.ArrayList;
import com.example.todo.service.TaskService;
import com.example.todo.entity.Task;

public class ConsoleUi {
  private final TaskService taskService;
  private ArrayList<Task> tasks;
  
  public ConsoleUi(TaskService taskService) {
    this.taskService = taskService;
    this.tasks = taskService.tasks;
  }

  public void showTasks() {
    for (Task task : tasks) {
      System.out.println("[" + task.id + "] - " + task.content);
    }
  }
}