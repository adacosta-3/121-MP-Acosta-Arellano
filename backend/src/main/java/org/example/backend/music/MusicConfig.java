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
                    "Let You Break My Heart Again",
                    "Let You Break My Heart Again",
                    "Laufey, Philharmonia Orchestra",
                    "https://t2.genius.com/unsafe/378x378/https%3A%2F%2Fimages.genius.com%2F3df60e3536af1ea4273af3526762caaa.1000x1000x1.jpg",
                    joy);
            Music j2 = new Music(
                    "T.H.E. Human Experience",
                    "This Can't Be It",
                    "Daj",
                    "https://t2.genius.com/unsafe/378x378/https%3A%2F%2Fimages.genius.com%2Fccede5ea6ced11ca1d45eaf3338fc748.464x464x1.jpg",
                    joy);
            Music j3 = new Music(
                    "Vanish",
                    "Take Time",
                    "Giveon",
                    "https://t2.genius.com/unsafe/378x378/https%3A%2F%2Fimages.genius.com%2F92e5e344a6a000db18be2b7f44303c20.1000x1000x1.png",
                    joy);
            Music j4 = new Music(
                    "Last Time (feat. Snoh Aalegra)",
                    "When It's All Said And Done...Take Time",
                    "Giveon",
                    "https://t2.genius.com/unsafe/378x378/https%3A%2F%2Fimages.genius.com%2Fe6d3b02e967a5726a623791434eddfd4.1000x1000x1.png",
                    joy);
            Music j5 = new Music(
                    "WOKE UP",
                    "WOKE UP",
                    "XG",
                    "https://t2.genius.com/unsafe/378x378/https%3A%2F%2Fimages.genius.com%2F2ab9e31152d12cec1ee5d6c28dd60426.1000x1000x1.png",
                    joy);

            repository.saveAll(List.of(a1,a2,a3,a4,a5,j1,j2,j3,j4,j5));
        };
    }
}
