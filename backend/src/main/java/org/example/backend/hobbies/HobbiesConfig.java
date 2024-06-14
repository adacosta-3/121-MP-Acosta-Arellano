package org.example.backend.hobbies;


import org.example.backend.user.User;
import org.example.backend.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class HobbiesConfig {

    @Order(4)
    @Bean
    CommandLineRunner hobbycommandLineRunner(HobbiesRepository repository, UserRepository userRepository) {
        return args -> {
            User arianne = userRepository.findUserByUsername("acostarianne").orElseThrow(() -> new IllegalStateException("User does not exist"));
            User joy = userRepository.findUserByUsername("joy__are").orElseThrow(() -> new IllegalStateException("User does not exist"));

            Hobby a1 = new Hobby(
                    "Watching Films",
                    "I love watching films when I have the time. I try to keep myself updated with various movie franchises (even the terrible ones), latest director releases, and current critically acclaimed films. Below is the trailer of my favorite release recently.",
                    "https://www.youtube.com/watch?v=XJMuhwVlca4&pp=ygUHZnVyaW9zYQ%3D%3D",
                    arianne);
            Hobby a2 = new Hobby(
                    "Playing Instruments",
                    "I play the piano and the guitar, but I can only strum chords on it as of the moment. I am currently learning how to play Mia & Sebastian's Theme from La La Land (2016) on the piano. ",
                    "https://youtu.be/uLF1lW3Ffrg",
                    arianne);
            Hobby a3 = new Hobby(
                    "Cooking",
                    "I find cooking for myself and for my family very therapeutic and rewarding.",
                    "https://youtu.be/rHgjRhgvR0g",
                    arianne);
            Hobby a4 = new Hobby(
                    "Fishkeeping",
                    "I have always been fascinated with marine life, and even animals in general. I currently have a small aquarium housing my fish Stacey and my snail Shelly. ",
                    "https://youtu.be/woSFGeMpoxI",
                    arianne);
            Hobby sewing = new Hobby(
                    "Sewing",
                    "Making my own articles of clothing",
                    "https://youtu.be/tBudnRKg_r8",
                    joy);

            repository.saveAll(List.of(a1,a2,a3,a4,sewing));
        };
    }
}
