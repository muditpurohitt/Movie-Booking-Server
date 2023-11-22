package com.Mudit.Bookmyshow.repositories;

import com.Mudit.Bookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllById(List<Long>showSeatIds);

    ShowSeat save(ShowSeat showSeat);
}
