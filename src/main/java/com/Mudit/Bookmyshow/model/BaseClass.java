package com.Mudit.Bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass // tells sb that the attributes of this class should be created as columns
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // generate the value of the id automatically
    private int id;
    private Date createdAt;
    private Date updatedAt;
}
