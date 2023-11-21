package com.Mudit.Bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseClass{
    private String name;
    private String emailid;
    private String phoneNo;
}
