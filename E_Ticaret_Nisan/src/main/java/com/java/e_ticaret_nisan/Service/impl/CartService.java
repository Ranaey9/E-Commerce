package com.java.e_ticaret_nisan.Service.impl;

import com.java.e_ticaret_nisan.Service.ICartService;
import com.java.e_ticaret_nisan.entitiy.Cart;
import com.java.e_ticaret_nisan.entitiy.CartItem;
import com.java.e_ticaret_nisan.entitiy.Product;
import com.java.e_ticaret_nisan.entitiy.User;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCartItem;
import com.java.e_ticaret_nisan.repository.ICartRepository;
import com.java.e_ticaret_nisan.repository.ICartitemRepository;
import com.java.e_ticaret_nisan.repository.IProcductRepository;
import com.java.e_ticaret_nisan.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;
    @Autowired
    private IProcductRepository producRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICartitemRepository cartitemRepository;

    @Override
    public void addProductToCart(Long userid, dtoCartItem cartItemdto) {
        Cart cart = cartRepository.findByUserId(userid);
        if (cart==null){
            Cart newCart = new Cart();
            User user = userRepository.findById(userid)
                    .orElseThrow(()-> new RuntimeException("kullanıcı bulunamadı"));

            newCart.setUser(user);
            newCart.setItems(new ArrayList<>());

            cartRepository.save(newCart);
            cart = newCart;
        }
        CartItem cartItem = new CartItem();

        Product product = producRepository.findById(cartItemdto.getProductid())
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(product.getId())){
                item.setQuantity(cartItemdto.getQuantity() + item.getQuantity());
                cartRepository.save(cart);
                return;
            }
        }

        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(cartItemdto.getQuantity());

        cart.getItems().add(cartItem);

        cartRepository.save(cart);
        return ;
    }
}
