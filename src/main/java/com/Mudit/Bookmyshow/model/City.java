package com.Mudit.Bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class City extends BaseClass{
    @OneToMany
    private List<Theatre> theatres;
    String name;
}
