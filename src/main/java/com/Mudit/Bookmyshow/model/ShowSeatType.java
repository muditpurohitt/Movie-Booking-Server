package com.Mudit.Bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

//not adding price in the ShowSeat class to save space and avoid redundancy
@Getter
@Setter
public class ShowSeatType {
    private Show show;
    private SeatType seatType;
    private Integer price;
}
