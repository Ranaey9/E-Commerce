package com.java.e_ticaret_nisan.entitiy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "urun")
//urun product
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //özellikleri
    private String description;

    private double price;

    private int stock;

    //Cinsiyet
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
