package com.Mudit.Bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theatre extends BaseClass{
    private String name;
    @ManyToOne
    private City city;
    @OneToMany
    private List<Screen> screenlist;
}
