package com.java.e_ticaret_nisan.controller;

import com.java.e_ticaret_nisan.entitiy.dto.dtoAllCategory;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCategory;

import java.util.List;

public interface ICategoryController {

    public String saveCategory(dtoCategory categoryName);
    public String deleteCategory(Long id);
    public dtoCategory getCategoryById(Long id);
    public List<dtoAllCategory> getAllCategories();

}
