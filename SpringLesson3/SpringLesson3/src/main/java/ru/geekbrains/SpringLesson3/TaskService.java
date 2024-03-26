package ru.geekbrains.SpringLesson3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks(){
        return tasks;
    }

    public Task getTask(UUID uuid){
        return tasks.stream()
                .filter(t -> t.getId().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    public Task addTask(Task task){
        tasks.add(task);
        return task;
    }

    public void deleteTask(UUID uuid){
        tasks.removeIf(t -> t.getId().equals(uuid));
    }

    public Task updateTask(UUID uuid, Task newTask){
        Task oldTask = getTask(uuid);
        if(oldTask != null){
            oldTask.setDescription(newTask.getDescription());
            oldTask.setName(newTask.getName());
            oldTask.setStatus(newTask.getStatus());
            oldTask.setCompletionTime(newTask.getCompletionTime());
        }
        return oldTask;
    }
}
