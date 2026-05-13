package com.java.e_ticaret_nisan.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<OrderItem> items;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double totalPrice;

    private int quantity;

    private LocalDateTime date;


}
