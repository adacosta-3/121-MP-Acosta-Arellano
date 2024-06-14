package org.example.backend.music;

import org.example.backend.user.User;
import org.example.backend.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class MusicConfig {

    @Order(3)
    @Bean
    CommandLineRunner musiccommandLineRunner(MusicRepository repository, UserRepository userRepository) {
        return args -> {
            User arianne = userRepository.findUserByUsername("acostarianne").orElseThrow(() -> new IllegalStateException("User does not exist"));
            User joy = userRepository.findUserByUsername("joy__are").orElseThrow(() -> new IllegalStateException("User does not exist"));

            Music a1 = new Music(
                    "Heartbreaker",
                    "Led Zeppelin II",
                    "Led Zeppelin",
                    "https://m.media-amazon.com/images/I/71mKCivU38L._SL1200_.jpg",
                    arianne);
            Music a2 = new Music(
                    "To Be Hunted",
                    "Atavista",
                    "Childish Gambino",
                    "https://upload.wikimedia.org/wikipedia/commons/a/aa/Atavista_by_Childish_Gambino_%28album_cover%29.png",
                    arianne);
            Music a3 = new Music(
                    "Casual",
                    "The Rise and Fall of a Midwest Princess",
                    "Chappell Roan",
                    "https://upload.wikimedia.org/wikipedia/en/3/34/Chappell_Roan_-_The_Rise_and_Fall_of_a_Midwest_Princess.png",
                    arianne);
            Music a4 = new Music(
                    "Wildflower and Barley",
                    "Unreal Unearth: Unheard",
                    "Hozier",
                    "https://images.genius.com/0f9be5c00fffa18c7878cfbf75ddba87.1000x1000x1.png",
                    arianne);
            Music a5 = new Music(
                    "Sundress",
                    "Sundress - Single",
                    "A$AP Rocky",
                    "https://upload.wikimedia.org/wikipedia/en/e/e5/ASAP_Rocky_%E2%80%93_Sundress.png",
                    arianne);
            Music j1 = new Music(
                    "Karma",
                    "Karma",
                    "JoJo Siwa",
                    "https://youtu.be/VZIm_2MgdeA",
                    joy);

            repository.saveAll(List.of(a1,a2,a3,a4,a5,j1));
        };
    }
}
