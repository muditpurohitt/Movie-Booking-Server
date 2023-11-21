package com.Mudit.Bookmyshow.services;

import com.Mudit.Bookmyshow.DTO.BookMovieRequestDto;
import com.Mudit.Bookmyshow.exceptions.SeatNotAvailableException;
import com.Mudit.Bookmyshow.exceptions.ShowNotFoundException;
import com.Mudit.Bookmyshow.exceptions.UserNotFoundException;
import com.Mudit.Bookmyshow.model.*;
import com.Mudit.Bookmyshow.repositories.ShowRepository;
import com.Mudit.Bookmyshow.repositories.ShowSeatRepository;
import com.Mudit.Bookmyshow.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//would be returning the Booking object and not a DTO because we want other services
//to also interact with this ans not just controller and if we return a dto, only booking controller
//will be able to interact. That would be tight coupling.

@Getter
@Setter
@Service //creates an object of BookingService at the time of compilation wherever necessary
public class BookingService {

    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private CalculatePriceService calculatePriceService;

    BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository,
                   ShowRepository showRepository,CalculatePriceService calculatePriceService){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.calculatePriceService = calculatePriceService;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId,Long showId, List<Long> showSeatIds) throws Exception{

        //1. Get the user object from userid
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("No such user exists!");
        }
        User bookedBy = optionalUser.get();

        //2. get the show object from show id
        Optional <Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("No such show available!");
        }
        Show show = optionalShow.get();

        //3. Get showseat object from showseatid (there are multiple show seats)
        List <ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        // (ideally)-----lock----------(not implemented in the project)

        //4. Check if all the show seats are available
        for(ShowSeat showSeat : showSeats){
            //If not available, throw exception.
            if(showSeat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE){
                throw new SeatNotAvailableException("The seats cannot be booked, try again with some other seats!");
            }
        }

        //6. If yes, change the staus to shoeseat to BLOCKED/LOCKED
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            //Save the changes in db as well
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        //       -----lock released----------
        //8. Payment service is not implemented so directly return the booking object
        //we are creating a booking object here and marking the status as pending till the booking is confirmed
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBookedAt(new Date());
        booking.setSeats(savedShowSeats);
        booking.setBookedByUser(bookedBy);
        booking.setShow(show);
        booking.setAmount(calculatePriceService.calculatePrice(show, savedShowSeats));

         return null;
    }
}
