package org.example.backend.hobbies;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.backend.user.User;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table
public class Hobby {

    @Id
    @SequenceGenerator(
            name = "hobbies_sequence",
            sequenceName = "hobbies_sequence",
            allocationSize = 1
    )

    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "hobbies_sequence"
    )

    private Long id;
    private String title;
    private String description;
    private String mediaLink;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public Hobby(String title, String description, String mediaLink, User user) {
        this.title = title;
        this.description = description;
        this.mediaLink = mediaLink;
        this.user = user;
    }
}
