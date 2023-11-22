package com.Mudit.Bookmyshow.repositories;

import com.Mudit.Bookmyshow.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long userId);
    Optional<User> findByEmailId(String email);
    User save(User user);
}
