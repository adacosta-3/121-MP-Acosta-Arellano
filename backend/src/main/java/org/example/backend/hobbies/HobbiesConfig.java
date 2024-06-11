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

            Hobby fishkeeping = new Hobby(
                    "Keeping Fish",
                    "Taking care of tropical fish and aquascaping",
                    "https://youtu.be/woSFGeMpoxI",
                    arianne);
            Hobby sewing = new Hobby(
                    "Sewing",
                    "Making my own articles of clothing",
                    "https://youtu.be/tBudnRKg_r8",
                    joy);

            repository.saveAll(List.of(fishkeeping,sewing));
        };
    }
}
