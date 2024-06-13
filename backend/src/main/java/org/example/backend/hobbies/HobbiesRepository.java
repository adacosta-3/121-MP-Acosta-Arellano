package org.example.backend.hobbies;

import org.example.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HobbiesRepository extends JpaRepository<Hobby, Long> {
    List<Hobby> findHobbyByUser(User user);

}
