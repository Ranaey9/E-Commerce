package com.java.e_ticaret_nisan.controller.impl;

import com.java.e_ticaret_nisan.Service.IProductService;
import com.java.e_ticaret_nisan.controller.IProductController;
import com.java.e_ticaret_nisan.entitiy.dto.CreateProductDto;
import com.java.e_ticaret_nisan.entitiy.dto.dtoProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/product")
public class ProductController implements IProductController {

    @Autowired
    private IProductService productService;

    @Override
    @PostMapping("/save")
    public dtoProduct saveProduct(@RequestBody @Valid CreateProductDto product) {
        return productService.saveProduct(product);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
        return;
    }

    @Override
    @GetMapping("/get/{id}")
    public dtoProduct getProductById(@PathVariable(name = "id") Long id) {
        return productService.getProductById(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<dtoProduct> getAllProducts() {
        return productService.getAllProducts();
    }
}
