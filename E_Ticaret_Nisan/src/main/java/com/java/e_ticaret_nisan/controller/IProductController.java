package com.java.e_ticaret_nisan.controller;

import com.java.e_ticaret_nisan.entitiy.dto.CreateProductDto;
import com.java.e_ticaret_nisan.entitiy.dto.dtoProduct;

import java.util.List;

public interface IProductController {

    public dtoProduct saveProduct(CreateProductDto product);
    public void deleteProduct(Long id);
    public dtoProduct getProductById(Long id);
    public List<dtoProduct> getAllProducts();

}
