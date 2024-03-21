package com.saigontech.interviewsample.assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController{

    private final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody TaskDto taskDto) {

        Task task = new Task(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());

        task = repository.save(task);

        return ResponseEntity.status(200).body(task.getId());

    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById(@PathVariable("id") Long id) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            return ResponseEntity.status(200).body(optionalTask.get().toDto());
        }
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        Optional<Task> optionalTask = repository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        Task task = optionalTask.get();

        if(taskDto.getTitle() != null && !taskDto.getTitle().isEmpty()){
            task.setTitle(taskDto.getTitle());
        }

        if(taskDto.getDescription() != null && !taskDto.getDescription().isEmpty()){
            task.setDescription(taskDto.getDescription());
        }

        try {
            TaskStatus status = TaskStatus.valueOf(taskDto.getStatus());
            task.setTaskStatus(status);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok("Available statuses are: CREATED,APPROVED,REJECTED,BLOCKED,DONE.");
        }

        repository.save(task);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/describe/{id}")
    public ResponseEntity<String> describe(@PathVariable Long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
            TaskDto dto = task.get().toDto();
            String response = String.format("[Description of Task [%s: %s] is: %s]", id, dto.getTitle(), dto.getDescription());
            return ResponseEntity.ok(response);
        }

        String response = String.format("[Task with id = %s does not exist]", id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> findAll() {
        List<TaskDto> response = new ArrayList<>();
        repository.findAll().forEach(task -> response.add(task.toDto()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/describe")
    public ResponseEntity<List<String>> describe() {
        List<String> response = new ArrayList<>();
        String responseFormat = "Description of Task [%s: %s] is: %s";
        repository.findAll().forEach(task -> {
            TaskDto dto = task.toDto();
            response.add(String.format(responseFormat, dto.getId(), dto.getTitle(), dto.getDescription()));
        });

        return ResponseEntity.ok(response);
    }
}
