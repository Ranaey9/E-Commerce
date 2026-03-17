package com.java.e_ticaret_nisan.Service;

import com.java.e_ticaret_nisan.entitiy.dto.CreateProductDto;
import com.java.e_ticaret_nisan.entitiy.dto.dtoProduct;

import java.util.List;

public interface IProductService {

    public dtoProduct saveProduct(CreateProductDto product);
    public void deleteProduct(Long id);
    public dtoProduct getProductById(Long id);
    public List<dtoProduct> getAllProducts();
}
