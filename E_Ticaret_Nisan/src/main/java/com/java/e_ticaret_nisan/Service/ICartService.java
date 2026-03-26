package com.java.e_ticaret_nisan.Service;

import com.java.e_ticaret_nisan.entitiy.dto.dtoCart;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCartItem;
import com.java.e_ticaret_nisan.entitiy.dto.dtoProductForAll;

import java.util.List;

public interface ICartService {

    public void addProductToCart(Long userid, dtoCartItem cartItem);
    public void removeProductFromCart(Long userid, dtoCartItem cartItemdto);
    public List<dtoProductForAll> getCartByUserId(Long userid);
    public double getCartTotalPrice(Long userid);

}
