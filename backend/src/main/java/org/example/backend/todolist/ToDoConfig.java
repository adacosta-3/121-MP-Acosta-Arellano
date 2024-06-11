package org.example.backend.todolist;

import org.example.backend.user.User;
import org.example.backend.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ToDoConfig {

    @Order(2)
    @Bean
    CommandLineRunner todocommandLineRunner(ToDoRepository repository, UserRepository userRepository) {
        return args -> {
            User arianne = userRepository.findUserByUsername("acostarianne").orElseThrow(() -> new IllegalStateException("User does not exist"));
            User joy = userRepository.findUserByUsername("joy__are").orElseThrow(() -> new IllegalStateException("User does not exist"));

            ToDo duolingo = new ToDo(
                    "Complete Duolingo",
                    "Practice Spanish for 5 minutes",
                    "#personal",
                    false,
                    arianne);
            ToDo bedsheets = new ToDo(
                    "Change bedsheets",
                    "Change bedsheets every 2 weeks. Make sure they match",
                    "#chores",
                    false,
                    arianne);
            ToDo grocery = new ToDo(
                    "Go grocery shopping",
                    "Buy food for condo",
                    "#chores",
                    false,
                    joy);

            repository.saveAll(List.of(duolingo,bedsheets,grocery));
        };
    }

}
