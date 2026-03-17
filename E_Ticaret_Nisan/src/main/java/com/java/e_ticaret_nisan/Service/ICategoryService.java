package com.java.e_ticaret_nisan.Service;


import com.java.e_ticaret_nisan.entitiy.Category;
import com.java.e_ticaret_nisan.entitiy.dto.dtoAllCategory;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCategory;

import java.util.List;

public interface ICategoryService {


    public String saveCategory(dtoCategory categoryName);
    public dtoCategory getCategoryById(Long id);
    public String deleteCategory(Long id);
    public List<dtoAllCategory> getAllCategories();

}
