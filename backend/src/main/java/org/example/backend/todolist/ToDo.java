package org.example.backend.todolist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import jakarta.persistence.*;
import org.example.backend.user.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table
public class ToDo {

    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )

    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )

    private Long id;
    private String task;
    private String description;
    private String label;
    private boolean completed;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public ToDo (String task, String description, String label, boolean completed, User user) {
        this.task = task;
        this.description = description;
        this.label = label;
        this.completed = completed;
        this.user = user;
    }

}
