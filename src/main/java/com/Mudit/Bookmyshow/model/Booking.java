package com.Mudit.Bookmyshow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Booking extends BaseClass{
    @Enumerated(EnumType.ORDINAL) // way to tell that this is a enum and the values will be in order
    private BookingStatus bookingStatus;
    @ManyToMany // not 1:m because we are supporting refund
    private List<ShowSeat> seats; //cardinality is not 1:m
    private Date bookedAt;
    @ManyToOne
    private User bookedByUser;
    @ManyToOne
    private Show show;
    private int amount;
    @OneToMany
    private List<Payment> payments;
}
