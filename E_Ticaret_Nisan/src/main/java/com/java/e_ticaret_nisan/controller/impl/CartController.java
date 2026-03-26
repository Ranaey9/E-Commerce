package com.java.e_ticaret_nisan.controller.impl;

import com.java.e_ticaret_nisan.Service.impl.CartService;
import com.java.e_ticaret_nisan.controller.ICartController;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCartItem;
import com.java.e_ticaret_nisan.entitiy.dto.dtoProductForAll;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/cart")
public class CartController implements ICartController {

    @Autowired
    private CartService cartService;


    @Override
    @PostMapping("/add")
    public void addProdactToCart(@RequestParam Long userid,
                                 @RequestBody @Valid dtoCartItem cartItem) {
        cartService.addProductToCart(userid,cartItem);
    }

    @Override
    @DeleteMapping("/deletProduct")
    public void removeProdactFromCart(@RequestParam Long userid,
                                      @RequestBody @Valid dtoCartItem cartItem) {
        cartService.removeProductFromCart(userid,cartItem);
    }

    @Override
    @GetMapping("/getCart/{id}")
    public List<dtoProductForAll> getCartByUserId(@PathVariable(name = "id") Long id) {
        return cartService.getCartByUserId(id);
    }

    @Override
    @GetMapping("/getTotalPrice/{userid}")
    public double getCartTotalPrice(@PathVariable(name = "userid") Long userid) {
        return cartService.getCartTotalPrice(userid);
    }


}
