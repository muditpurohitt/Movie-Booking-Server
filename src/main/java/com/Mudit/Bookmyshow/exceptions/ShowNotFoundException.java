package com.Mudit.Bookmyshow.exceptions;

import com.Mudit.Bookmyshow.repositories.ShowSeatRepository;

public class ShowNotFoundException extends Exception{
    public ShowNotFoundException(String message){
        super(message);
    }
}
