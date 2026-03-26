package com.java.e_ticaret_nisan.controller;

import com.java.e_ticaret_nisan.entitiy.dto.dtoCartItem;
import com.java.e_ticaret_nisan.entitiy.dto.dtoProductForAll;

import java.util.List;

public interface ICartController {

    public void addProdactToCart(Long userid, dtoCartItem cartItem);
    public void removeProdactFromCart(Long userid, dtoCartItem cartItem);
    public List<dtoProductForAll> getCartByUserId(Long id);
    public double getCartTotalPrice(Long userid);


}
