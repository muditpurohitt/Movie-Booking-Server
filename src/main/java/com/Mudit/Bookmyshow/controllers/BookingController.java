package com.Mudit.Bookmyshow.controllers;

import com.Mudit.Bookmyshow.DTO.BookMovieRequestDto;
import com.Mudit.Bookmyshow.DTO.BookMovieResponseDto;
import com.Mudit.Bookmyshow.model.Booking;
import com.Mudit.Bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;
    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto){
        return null;
    }
}
