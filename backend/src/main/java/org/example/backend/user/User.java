package org.example.backend.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.backend.hobbies.Hobby;
import org.example.backend.music.Music;
import org.example.backend.todolist.ToDo;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name="users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ToDo> todos;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Music> music;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Hobby> hobby;

    private String name;
    private String nickname;
    private LocalDate dob;
    private String email;
    private String username;
    @Transient
    private Integer age;

    public User(String name, String nickname, LocalDate dob, String email, String username) {
        this.name = name;
        this.nickname = nickname;
        this.dob = dob;
        this.email = email;
        this.username = username;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
