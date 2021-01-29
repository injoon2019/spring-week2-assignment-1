package com.codesoom.assignment.controllers;

import com.codesoom.assignment.models.Task;
import com.codesoom.assignment.repositories.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private Long id = 0L;
    private TaskRepository taskRepository = new TaskRepository();

    @GetMapping
    public List<Task> list() {
        return taskRepository.getTasks();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        task.setId(generateId());
        taskRepository.getTasks().add(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task source) {
        Task task = getTask(id);
        task.setTitle(source.getTitle());
        return task;
    }

    private Task getTask(Long id) {
        return taskRepository.getTasks().stream()
                .filter(task -> task.getId().equals(id))
                .findFirst().orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, @RequestBody Task task) {

        task = getTask(id);
        taskRepository.getTasks().remove(task);
        return "";
    }

    private Long generateId() {
        id++;
        return id;
    }

}
