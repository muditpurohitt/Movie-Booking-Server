package com.Mudit.Bookmyshow.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMovieRequestDto {
    private Long userid;
    private Long showId;
    private List<Long> showSeatId;
}
