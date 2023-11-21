package com.Mudit.Bookmyshow.repositories;

import com.Mudit.Bookmyshow.model.Show;
import com.Mudit.Bookmyshow.model.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Show show);
}
