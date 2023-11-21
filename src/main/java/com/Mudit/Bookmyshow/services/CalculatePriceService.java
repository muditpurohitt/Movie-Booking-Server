package com.Mudit.Bookmyshow.services;

import com.Mudit.Bookmyshow.model.Show;
import com.Mudit.Bookmyshow.model.ShowSeat;
import com.Mudit.Bookmyshow.model.ShowSeatType;
import com.Mudit.Bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatePriceService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public CalculatePriceService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    Integer calculatePrice(Show show, List<ShowSeat> showSeats){
        int amount = 0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        for(ShowSeat showSeat: showSeats){
            for(ShowSeatType showSeatType: showSeatTypes){
                if(showSeatType.getSeatType() == showSeat.getSeat().getSeatType()){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
