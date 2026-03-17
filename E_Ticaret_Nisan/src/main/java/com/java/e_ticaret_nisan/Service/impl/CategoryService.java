package com.java.e_ticaret_nisan.Service.impl;

import com.java.e_ticaret_nisan.Service.ICategoryService;
import com.java.e_ticaret_nisan.entitiy.Category;
import com.java.e_ticaret_nisan.entitiy.dto.dtoAllCategory;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCategory;
import com.java.e_ticaret_nisan.repository.ICategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public String saveCategory(dtoCategory categoryName) {
        if (categoryRepository.existsByName(categoryName.getName())){
            throw new RuntimeException("Bu kategori zaten var");
        }
        Category saveCategory = new Category();
        BeanUtils.copyProperties(categoryName,saveCategory);
        categoryRepository.save(saveCategory);
        return "Category saved successfully";
    }

    @Override
    public dtoCategory getCategoryById(Long id) {
        if (!categoryRepository.existsById(id)){
            throw new NullPointerException("id sahip ürün bulunamadı");
        }
        Category category = categoryRepository.findById(id).get();
        dtoCategory dtoCategory = new dtoCategory();
        BeanUtils.copyProperties(category,dtoCategory);
        return dtoCategory;
    }

    @Override
    public String deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)){
            throw new RuntimeException("id sahip ürün bulunamadı");
        }
        categoryRepository.deleteById(id);
        return "Silme başarılı";
    }

    @Override
    public List<dtoAllCategory> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<dtoAllCategory> dtoList = new ArrayList<>();
        for (Category category : categories) {
            dtoAllCategory dtoAllCategory = new dtoAllCategory();
            BeanUtils.copyProperties(category,dtoAllCategory);
            dtoList.add(dtoAllCategory);
        }
        return dtoList;
    }
}
