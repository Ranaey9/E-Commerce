package com.java.e_ticaret_nisan.entitiy.dto;

import com.java.e_ticaret_nisan.entitiy.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoProduct {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String image;
    private Gender gender;

}
