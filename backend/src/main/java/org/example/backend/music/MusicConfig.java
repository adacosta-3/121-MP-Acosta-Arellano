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

            Music uno = new Music(
                    "Never Gonna Give You Up",
                    "Whenever You Need Somebody",
                    "Rick Astley",
                    "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                    arianne);
            Music dos = new Music(
                    "Karma",
                    "Karma",
                    "JoJo Siwa",
                    "https://youtu.be/VZIm_2MgdeA",
                    joy);

            repository.saveAll(List.of(uno,dos));
        };
    }
}
