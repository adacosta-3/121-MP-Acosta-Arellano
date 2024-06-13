package org.example.backend.hobbies;

import org.example.backend.music.Music;
import org.example.backend.user.User;
import org.example.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hobbies")
public class HobbiesController {
    private final HobbiesService hobbiesService;
    private final UserRepository userRepository;

    @Autowired
    public HobbiesController(HobbiesService hobbiesService, UserRepository userRepository) {
        this.hobbiesService = hobbiesService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Hobby> getHobbies() {
        return hobbiesService.getHobbies();
    }

    @GetMapping("/user/{userId}")
    public List<Hobby> getHobbiesByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        return hobbiesService.getHobbiesByUser(user);
    }

    @PostMapping
    public void addNewHobbies(@RequestBody Hobby hobby) {
        hobbiesService.addNewHobby(hobby);
    }

    @DeleteMapping(path = "{hobbyId}")
    public void deleteHobbies(@PathVariable("hobbyId") Long hobbyId) {
            hobbiesService.deleteHobby(hobbyId);
    }
}
