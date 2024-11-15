package com.example.taskone.configuration;

import com.example.taskone.model.Task;
import com.example.taskone.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(TaskRepository taskRepository) {
        return args -> {
            taskRepository.save(new Task("задача 1", "Описание задачи 1", 101L));
            taskRepository.save(new Task("задача 2", "Описание задачи 2", 102L));
            taskRepository.save(new Task("задача 3", "Описание задачи 3", 103L));
        };
    }
}
