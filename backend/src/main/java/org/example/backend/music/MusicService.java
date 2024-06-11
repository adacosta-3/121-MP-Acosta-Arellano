package org.example.backend.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> getMusic() {
        return musicRepository.findAll();
    }
    public void addNewMusic(Music music) {
        musicRepository.save(music);
    }

    public void deleteMusic(Long musicId) {
        boolean exists = musicRepository.existsById(musicId);
        if (!exists) {
            throw new IllegalStateException("Music with id " + musicId + " does not exist");
        }
        musicRepository.deleteById(musicId);
    }

}

