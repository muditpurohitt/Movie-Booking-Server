package com.Mudit.Bookmyshow.DTO;

import com.Mudit.Bookmyshow.model.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private BookingStatus bookingStatus;
    private Long bookingId;
    private int amount;
}
