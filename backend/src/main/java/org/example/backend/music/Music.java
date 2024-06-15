package org.example.backend.music;

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
public class Music {

    @Id
    @SequenceGenerator(
            name = "music_sequence",
            sequenceName = "music_sequence",
            allocationSize = 1
    )

    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "music_sequence"
    )

    private Long id;
    private String song;
    private String album;
    private String artist;
    private String aaLink; // album art
    private String spLink; // spotify link

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;


    public Music (String song, String album, String artist, String aaLink, String spLink, User user) {
        this.song = song;
        this.album = album;
        this.artist = artist;
        this.aaLink = aaLink;
        this.spLink = spLink;
        this.user = user;
    }
}
