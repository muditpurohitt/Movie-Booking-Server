package com.Mudit.Bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseClass{
    private String seatNum;
    private int rowNo;
    private int colNo;
    @ManyToOne
    private SeatType seatType;
}
