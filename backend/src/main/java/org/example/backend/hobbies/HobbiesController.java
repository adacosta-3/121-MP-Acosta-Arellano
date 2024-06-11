package org.example.backend.hobbies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hobbies")
public class HobbiesController {
    private final HobbiesService hobbiesService;

    @Autowired
    public HobbiesController(HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }

    @GetMapping
    public List<Hobby> getHobbies() {
        return hobbiesService.getHobbies();
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
