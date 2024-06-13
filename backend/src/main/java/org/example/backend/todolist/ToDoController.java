package org.example.backend.todolist;


import org.example.backend.user.User;
import org.example.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/todos")
public class ToDoController {
    private final ToDoService toDoService;
    private final UserRepository userRepository;

    @Autowired
    public ToDoController(ToDoService toDoService, UserRepository userRepository) {
        this.toDoService = toDoService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<ToDo> getToDos() { return toDoService.getToDos(); }

    @GetMapping("/user/{userId}")
    public List<ToDo> getToDosByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        return toDoService.getToDosByUser(user);
    }

    @GetMapping("/user/{userId}/completed")
    public List<ToDo> getCompletedToDosByUser(@PathVariable Long userId) {
        return toDoService.getCompletedToDosByUser(userId);
    }

    @GetMapping("/user/{userId}/unfinished")
    public List<ToDo> getUnfinishedToDosByUser(@PathVariable Long userId) {
        return toDoService.getUnfinishedToDosByUser(userId);
    }

    @GetMapping("/filter")
    public List<ToDo> filterToDosByLabel(@RequestParam Long userId, @RequestParam String label) {
        User user = new User();
        user.setId(userId);
        return toDoService.filterToDosByLabel(user, label);
    }

    @GetMapping("/user/{userId}/label/{label}/completed")
    public List<ToDo> getCompletedToDosByUserAndLabel(@PathVariable Long userId, @PathVariable String label) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User does not exist"));
        return toDoService.getToDosByUserAndLabelAndCompleted(user, label, true);
    }

    @GetMapping("/user/{userId}/label/{label}/unfinished")
    public List<ToDo> getUnfinishedToDosByUserAndLabel(@PathVariable Long userId, @PathVariable String label) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User does not exist"));
        return toDoService.getToDosByUserAndLabelAndCompleted(user, label, false);
    }

    @GetMapping("/user/{userId}/labels")
    public List<String> getLabelsByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User does not exist"));
        return toDoService.getLabelsByUser(user);
    }

    @PostMapping
    public void addNewTodo(@RequestBody ToDo todo){toDoService.addNewToDo(todo);}

    @DeleteMapping(path = "{todoId}")
    public void deleteToDo(@PathVariable("todoId") Long todoId) {
        toDoService.deleteToDo(todoId);
    }

    @PutMapping(path = "update/{todoId}")
    public void updateToDo(
            @PathVariable Long todoId,
            @RequestParam(required = false) String task,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String label) {
        toDoService.updateToDo(todoId, task, description, label);
    }

    @PutMapping(path = "/completion/{todoId}")
    public void updateCompletion(@PathVariable("todoId") Long todoId, @RequestParam boolean completed) {
        System.out.println("Received request to update completion status of todo with ID: " + todoId + " to " + completed);
        toDoService.updateCompletion(todoId, completed);
    }
}
