package com.Mudit.Bookmyshow.DTO;

import com.Mudit.Bookmyshow.model.BookingStatus;
import com.Mudit.Bookmyshow.model.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
    private Integer userId;
    private ResponseStatus responseStatus;
}
