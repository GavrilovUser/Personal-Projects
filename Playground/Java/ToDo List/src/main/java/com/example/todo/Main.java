package com.example.todo;

import com.example.todo.service.TaskService;
import com.example.todo.ui.ConsoleUi;
import com.example.todo.util.Useful;

public class Main {
  public static void main(String[] args) {
    //В точке входа все это есть, для быстрого теста программы
    TaskService taskService = new TaskService();
    ConsoleUi consoleUi = new ConsoleUi(taskService);

    //Создаем 10 новых задач оптом
    Useful.createManyTasks(10, taskService);

    //Убираем задачу с ID 3
    taskService.removeTask(3);

    //Создаем задание
    taskService.newTask("Тестовое задание");

    //Создаем 4 новых задачи оптом
    Useful.createManyTasks(4, taskService);

    //Убираем задачу с ID 9
    taskService.removeTask(9);

    //Показываем все задачи
    consoleUi.showTasks();
  }
}