package org.example.backend.hobbies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbiesService {

    private final HobbiesRepository hobbiesRepository;

    @Autowired
    public HobbiesService(HobbiesRepository hobbiesRepository) {
        this.hobbiesRepository = hobbiesRepository;
    }

    public List<Hobby> getHobbies() { return hobbiesRepository.findAll(); }

    public void addNewHobby(Hobby hobby) {
        hobbiesRepository.save(hobby);
    }

    public void deleteHobby(Long hobbyId) {
        boolean exists = hobbiesRepository.existsById(hobbyId);
        if (!exists) {
            throw new IllegalStateException("Hobby with id " + hobbyId + " does not exist");
        }
        hobbiesRepository.deleteById(hobbyId);
    }

}
