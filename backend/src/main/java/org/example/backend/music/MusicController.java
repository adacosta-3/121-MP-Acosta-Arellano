package org.example.backend.music;

import org.example.backend.user.User;
import org.example.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {
    private final MusicService musicService;
    private final UserRepository userRepository;

    @Autowired
    public MusicController(MusicService musicService, UserRepository userRepository) {
        this.musicService = musicService;

        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Music> getMusic() {
        return musicService.getMusic();
    }

    @GetMapping("/user/{userId}")
    public List<Music> getMusicByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        return musicService.getMusicByUser(user);
    }

    @PostMapping
    public void addNewMusic(@RequestBody Music music) {
        musicService.addNewMusic(music);
    }

    @DeleteMapping(path = "{musicId}")
    public void deleteMusic(@PathVariable("musicId") Long musicId) {
        musicService.deleteMusic(musicId);
    }

}
