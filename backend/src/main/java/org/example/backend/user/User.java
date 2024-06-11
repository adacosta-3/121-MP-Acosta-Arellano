package org.example.backend.user;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;
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
        this.dob =

    }

}
