package com.java.e_ticaret_nisan.controller;

import com.java.e_ticaret_nisan.entitiy.dto.dtoCartItem;

public interface ICartController {

    public void addProdactToCart(Long userid, dtoCartItem cartItem);


}
