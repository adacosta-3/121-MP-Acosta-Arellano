package org.example.backend.todolist;

import org.example.backend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/todos")
public class ToDoController {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getToDos() { return toDoService.getToDos(); }

    @GetMapping(path = "user/{userId}")
    public List<ToDo> getToDosByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return toDoService.getToDosByUser(user);
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
