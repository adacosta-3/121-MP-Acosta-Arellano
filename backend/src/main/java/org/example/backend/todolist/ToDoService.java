package org.example.backend.todolist;

import org.example.backend.user.User;
import org.example.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, UserRepository userRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
    }

    public List<ToDo> getToDos() { return toDoRepository.findAll(); }
    public List<ToDo> getToDosByUser(User user) { return toDoRepository.findToDoByUser(user); }

    public void addNewToDo(ToDo toDo) {
        toDo.setCreatedAt(LocalDateTime.now());
        toDoRepository.save(toDo);
    }

    public void deleteToDo(Long todoId) {
        boolean exists = toDoRepository.existsById(todoId);
        if (!exists) { throw new IllegalStateException("To-Do entry with id " + todoId + " does not exist"); }
        toDoRepository.deleteById(todoId);
    }

    public void updateToDo(Long todoId, String task, String description, String label) {
        ToDo toDo = toDoRepository.findById(todoId).orElseThrow(() -> new IllegalStateException("To-Do with id " + todoId + " does not exist"));

        if (task != null && !task.isEmpty() && !Objects.equals(toDo.getTask(), task)) {
            toDo.setTask(task);
        }

        if (description != null && !description.isEmpty() && !Objects.equals(toDo.getDescription(), description)) {
            toDo.setDescription(description);
        }

        if (label != null && !label.isEmpty() && !Objects.equals(toDo.getLabel(), label)) {
            toDo.setLabel(label);
        }
    }

    public List<ToDo> filterToDosByLabel(User user, String label) { return toDoRepository.findToDoByUserAndLabel(user, label); }

    public void updateCompletion(Long todoId, boolean completed) {
        ToDo todo = toDoRepository.findById(todoId).orElseThrow(() -> new IllegalStateException("To-Do entry with id " + todoId + " does not exist"));
        todo.setCompleted(completed);
        todo.setCompletedAt(completed ? LocalDateTime.now() : null);
    }

    public List<ToDo> getCompletedToDosByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User does not exist"));
        return toDoRepository.findToDoByUserAndCompleted(user, true);
    }

    public List<ToDo> getUnfinishedToDosByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User does not exist"));
        return toDoRepository.findToDoByUserAndCompleted(user, false);
    }
}
