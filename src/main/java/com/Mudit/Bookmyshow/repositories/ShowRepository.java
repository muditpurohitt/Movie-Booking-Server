package com.Mudit.Bookmyshow.repositories;

import com.Mudit.Bookmyshow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface ShowRepository extends JpaRepository <Show, Long> {
    @Override
    Optional<Show> findById(Long showId);
}
