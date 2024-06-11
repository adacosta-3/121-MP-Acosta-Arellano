package org.example.backend.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {
    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public List<Music> getMusic() {
        return musicService.getMusic();
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
