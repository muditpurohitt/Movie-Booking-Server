package com.Mudit.Bookmyshow.repositories;

import com.Mudit.Bookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllById(List<Long>showSeatIds);

    ShowSeat save(ShowSeat showSeat);
}
