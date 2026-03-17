package com.java.e_ticaret_nisan.entitiy.dto;

import com.java.e_ticaret_nisan.entitiy.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoCartItem {

    private Long productid;
    private int quantity;

}
