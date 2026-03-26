package com.java.e_ticaret_nisan.entitiy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class dtoProductForAll {

    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String image;
    private Double totalPrice;
}
