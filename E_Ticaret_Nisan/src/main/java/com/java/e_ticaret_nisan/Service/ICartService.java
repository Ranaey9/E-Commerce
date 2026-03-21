package com.java.e_ticaret_nisan.Service;

import com.java.e_ticaret_nisan.entitiy.dto.dtoCart;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCartItem;

public interface ICartService {

    public void addProductToCart(Long userid, dtoCartItem cartItem);
    public void removeProductFromCart(Long userid, dtoCartItem cartItemdto);

}
