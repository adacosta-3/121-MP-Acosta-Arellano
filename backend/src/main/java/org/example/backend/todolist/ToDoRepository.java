package org.example.backend.todolist;

import org.example.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findToDoByUser(User user);
    List<ToDo> findToDoByUserAndLabel(User user, String label);
    List<ToDo> findToDoByUserAndCompleted(User user, boolean completed);
    List<ToDo> findToDoByUserAndLabelAndCompleted(User user, String label, boolean completed);
    @Query("SELECT DISTINCT t.label FROM ToDo t WHERE t.user = :user")
    List<String> findDistinctLabelsByUser(@Param("user") User user);
}
