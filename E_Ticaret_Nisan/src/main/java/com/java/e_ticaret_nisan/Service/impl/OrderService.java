package com.java.e_ticaret_nisan.Service.impl;

import com.java.e_ticaret_nisan.Service.IOrderService;
import com.java.e_ticaret_nisan.entitiy.*;
import com.java.e_ticaret_nisan.repository.ICartRepository;
import com.java.e_ticaret_nisan.repository.IOrderRepository;
import com.java.e_ticaret_nisan.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICartRepository cartRepository;
    @Autowired
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    @Override
    public String createOrder(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("Kullanıcı bulunamadı"));

        Cart cart = user.getCart();

        if (cart==null || cart.getItems().isEmpty()){
            throw new RuntimeException("Sepet Boş");
        }
        List<OrderItem> orderItems = new ArrayList<>();
        double totalPrice = 0;
        double total =0;
        int quantity = 0;

        Order order = new Order();
        order.setUser(user);

        for (CartItem cartItem : cart.getItems()) {

            OrderItem orderItem = new OrderItem();

            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice());

            orderItem.setOrder(order);

            orderItems.add(orderItem);

            totalPrice = cartItem.getProduct().getPrice() * cartItem.getQuantity();
            total += totalPrice;

            orderItem.setTotalPrice(totalPrice);
            quantity++;
        }
        order.setTotalPrice(total);
        order.setItems(orderItems);
        order.setDate(LocalDateTime.now());
        order.setQuantity(quantity);
        orderRepository.save(order);

        cart.getItems().clear();
        cartRepository.save(cart);

        return "sipariş geçmiş siparişlere eklendi";
    }
}
