package org.example.backend.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Order(1)
    @Bean
    CommandLineRunner usercommandLineRunner(UserRepository repository) {
        return args -> {
            User arianne = new User(
                    "Arianne Jayne D. Acosta",
                    "Arianne",
                    LocalDate.of(2005,Month.JANUARY,1),
                    "adacosta3@up.edu.ph",
                    "acostarianne");
            User joy = new User(
                    "Kristine Joy B. Arellano",
                    "Joy",
                    LocalDate.of(2002,Month.OCTOBER,26),
                    "kbarellano3@up.edu.ph",
                    "joy__are");
            repository.saveAll(List.of(arianne,joy));
        };
    }
}
