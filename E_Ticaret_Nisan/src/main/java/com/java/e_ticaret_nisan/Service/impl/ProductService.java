package com.java.e_ticaret_nisan.Service.impl;

import com.java.e_ticaret_nisan.Service.IProductService;
import com.java.e_ticaret_nisan.entitiy.Product;
import com.java.e_ticaret_nisan.entitiy.dto.CreateProductDto;
import com.java.e_ticaret_nisan.entitiy.dto.dtoProduct;
import com.java.e_ticaret_nisan.repository.IProcductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProcductRepository procductRepository;

    @Override
    public dtoProduct saveProduct(CreateProductDto product) {
        Product saveProduct = new Product();
        BeanUtils.copyProperties(product,saveProduct);
        saveProduct = procductRepository.save(saveProduct);
        dtoProduct dtoProduct = new dtoProduct();
        BeanUtils.copyProperties(saveProduct,dtoProduct);
        return dtoProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        if (!procductRepository.existsById(id)){
            throw new RuntimeException("Ürün bulunamadı");
        }
        Product deleteProduct = procductRepository.findById(id).get();
        procductRepository.delete(deleteProduct);
        System.out.println("Ürün silindi");
        return;
    }

    @Override
    public dtoProduct getProductById(Long id) {
        if (!procductRepository.existsById(id)){
            throw new RuntimeException("Ürün bulunamadı");
        }
        Product product = procductRepository.findById(id).get();
        dtoProduct dtoProduct = new dtoProduct();
        BeanUtils.copyProperties(product,dtoProduct);
        return dtoProduct;
    }

    @Override
    public List<dtoProduct> getAllProducts() {
        List<Product> products = procductRepository.findAll();
        List<dtoProduct> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoProduct dtoProduct = new dtoProduct();
            BeanUtils.copyProperties(product,dtoProduct);
            dtoList.add(dtoProduct);
        }
        return dtoList;
    }
}
