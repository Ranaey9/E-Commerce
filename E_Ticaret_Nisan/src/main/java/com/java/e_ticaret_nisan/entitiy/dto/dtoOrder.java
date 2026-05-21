package com.java.e_ticaret_nisan.entitiy.dto;

import java.time.LocalDateTime;
import java.util.List;

public class dtoOrder {

    private Long id;

    private Double totalPrice;

    private int quantity;

    private LocalDateTime createdDate;

    private List<dtoOrderItem> items;

}
