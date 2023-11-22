package com.Mudit.Bookmyshow.controllers;

import com.Mudit.Bookmyshow.DTO.BookMovieRequestDto;
import com.Mudit.Bookmyshow.DTO.BookMovieResponseDto;
import com.Mudit.Bookmyshow.exceptions.UserNotFoundException;
import com.Mudit.Bookmyshow.model.Booking;
import com.Mudit.Bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {
    private BookingService bookingService;
    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto){
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();

        Long userId = bookMovieRequestDto.getUserid();
        Long showId = bookMovieRequestDto.getShowId();
        List<Long> showSeatIds = bookMovieRequestDto.getShowSeatId();

        try{
            Booking booking = bookingService.bookMovie(userId, showId, showSeatIds);
            bookMovieResponseDto.setBookingId(booking.getId());
            bookMovieResponseDto.setBookingStatus(booking.getBookingStatus());
            bookMovieResponseDto.setAmount(booking.getAmount());

            return bookMovieResponseDto;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return bookMovieResponseDto;
    }
}
