package org.example.backend.todolist;


import org.example.backend.user.User;
import org.example.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void addNewToDo(@RequestBody ToDo toDo) {
        toDoService.addNewToDo(toDo);
    }

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

    @PutMapping(path = "completion/{todoId}")
    public void updateCompletion(@PathVariable("todoId") Long todoId, @RequestParam boolean completed) {
        toDoService.updateCompletion(todoId, completed);
    }
}
