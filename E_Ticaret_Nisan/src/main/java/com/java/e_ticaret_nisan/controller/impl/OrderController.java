package com.java.e_ticaret_nisan.controller.impl;

import com.java.e_ticaret_nisan.Service.IOrderService;
import com.java.e_ticaret_nisan.controller.IOrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/order")
public class OrderController implements IOrderController {

    @Autowired
    private IOrderService orderService;

    @Override
    @PostMapping("/create/{userId}")
    public String createOrder(@PathVariable(name = "userId") Long userId) {
        return orderService.createOrder(userId);
    }
}
