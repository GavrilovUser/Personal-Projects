package com.example.todo.service;

import java.util.ArrayList;
import com.example.todo.entity.Task;
import com.example.todo.util.Useful;

public class TaskService {
  public ArrayList<Task> tasks = new ArrayList<>();
  public int totalIds = 1;
  
  public Task newTask(String content) {
    Task task = new Task(content, totalIds);
    tasks.add(task);

    totalIds++;
    
    return task;
  }

  public boolean removeTask(int id) {
    int tasksSize = tasks.size();
    
    if (tasks.stream().anyMatch(task -> task.id == id)) {
      tasks.removeIf(task -> task.id == id);

      return true;
    } else {
      return false;
    }
  }
}