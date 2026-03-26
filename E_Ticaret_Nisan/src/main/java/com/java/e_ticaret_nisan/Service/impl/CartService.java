package com.java.e_ticaret_nisan.Service.impl;

import com.java.e_ticaret_nisan.Service.ICartService;
import com.java.e_ticaret_nisan.entitiy.Cart;
import com.java.e_ticaret_nisan.entitiy.CartItem;
import com.java.e_ticaret_nisan.entitiy.Product;
import com.java.e_ticaret_nisan.entitiy.User;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCartItem;
import com.java.e_ticaret_nisan.entitiy.dto.dtoProductForAll;
import com.java.e_ticaret_nisan.repository.ICartRepository;
import com.java.e_ticaret_nisan.repository.ICartitemRepository;
import com.java.e_ticaret_nisan.repository.IProcductRepository;
import com.java.e_ticaret_nisan.repository.IUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        if (cartItemdto.getQuantity() <= 0) {
            throw new RuntimeException("Ürün adedi 0 veya negatif olamaz");
        }

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

        Product product = producRepository.findById(cartItemdto.getProductid())
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        if (cartItemdto.getQuantity()>product.getStock()){
            throw new RuntimeException("Stok yeterli değil");
        }

        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(product.getId())){
                int newQuantity = item.getQuantity() + cartItemdto.getQuantity();
                if (newQuantity>product.getStock()){
                    throw new RuntimeException("Stok yeterli değil");
                }
                item.setQuantity(newQuantity);
                cartRepository.save(cart);
                return;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(cartItemdto.getQuantity());

        cart.getItems().add(cartItem);

        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(Long userid, dtoCartItem cartItemdto) {
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        Cart cart = cartRepository.findById(user.getCart().getId())
                .orElseThrow(() -> new RuntimeException("sepet bulunamadı"));

        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(cartItemdto.getProductid())) {
                int newquantity = item.getQuantity() - cartItemdto.getQuantity();
                if (newquantity < 0) {
                    throw new RuntimeException("Ürün sayısı negatif olamaz");
                } else if (newquantity == 0) {
                    cart.getItems().remove(item);
                } else {
                    item.setQuantity(newquantity);
                }
                cartRepository.save(cart);
                return;
            }
        }
        throw new RuntimeException("Sepette bu ürüne ait kayıt bulunamadı");
    }

    @Override
    public List<dtoProductForAll> getCartByUserId(Long userid) {

        User user = userRepository.findById(userid)
                .orElseThrow(()-> new RuntimeException("Kullanıcı bulunamadı"));
        List<dtoProductForAll> dtoProductlist = new ArrayList<>();
        List<CartItem> liste = user.getCart().getItems();
        if (liste==null && liste.isEmpty()){
            throw new RuntimeException("Sepet Bulunamadı/Sepet Boş");
        }
        for (CartItem item : liste) {
            dtoProductForAll dtoProduct = new dtoProductForAll();
            BeanUtils.copyProperties(item.getProduct(), dtoProduct);
            dtoProduct.setQuantity(item.getQuantity());
            dtoProduct.setTotalPrice(item.getQuantity() * item.getProduct().getPrice());
            dtoProductlist.add(dtoProduct);
        }

        return dtoProductlist;
    }

    @Override
    public double getCartTotalPrice(Long userid) {
        User user = userRepository.findById(userid)
                .orElseThrow(()-> new RuntimeException("Kullanıcı bulunamadı"));
        List<dtoProductForAll> dtoProductlist = new ArrayList<>();
        List<CartItem> liste = user.getCart().getItems();
        double totalPrice = 0;
        for (CartItem item : liste) {
            totalPrice += item.getQuantity() * item.getProduct().getPrice();
        }
        return totalPrice;
    }
}
