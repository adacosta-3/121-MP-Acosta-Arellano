package org.example.backend.todolist;

import org.example.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findToDoByUser(User user);
    List<ToDo> findToDoByUserAndLabel(User user, String label);
    List<ToDo> findToDoByUserAndCompleted(User user, boolean completed);
}
