package com.Mudit.Bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Movie extends BaseClass{
    String movieName;

}
