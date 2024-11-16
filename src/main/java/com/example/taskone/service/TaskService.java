package com.example.taskone.service;

import com.example.taskone.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task taskDetails);
    boolean deleteTask(Long id);

}
