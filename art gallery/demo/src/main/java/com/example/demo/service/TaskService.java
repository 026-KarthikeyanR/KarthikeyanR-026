package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepository;

    // Retrieve all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Retrieve a task by ID
    public Task getTaskById(Long id) {
        return taskRepository.getById(id);
    }

    // Create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Update an existing task
    public Task update(long id,Task t){
        t.setId(id);
        return taskRepository.getById(id);
    }
    // Delete a task by ID
    public void del(long id){
        taskRepository.deleteById(id);
    }
}
