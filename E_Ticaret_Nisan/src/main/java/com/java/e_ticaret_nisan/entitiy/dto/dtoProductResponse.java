package com.java.e_ticaret_nisan.entitiy.dto;

import com.java.e_ticaret_nisan.entitiy.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class dtoProductResponse {

    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String image;
    private Gender gender;
}
