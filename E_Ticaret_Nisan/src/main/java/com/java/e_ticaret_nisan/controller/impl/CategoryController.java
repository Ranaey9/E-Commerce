package com.java.e_ticaret_nisan.controller.impl;

import com.java.e_ticaret_nisan.Service.ICategoryService;
import com.java.e_ticaret_nisan.controller.ICategoryController;
import com.java.e_ticaret_nisan.entitiy.dto.dtoAllCategory;
import com.java.e_ticaret_nisan.entitiy.dto.dtoCategory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/category")
public class CategoryController implements ICategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Override
    @PostMapping("/save")
    public String saveCategory(@RequestBody @Valid dtoCategory categoryName) {
        return categoryService.saveCategory(categoryName);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable(name = "id") Long id) {
        return categoryService.deleteCategory(id);
    }

    @Override
    @GetMapping("/get/{id}")
    public dtoCategory getCategoryById(@PathVariable(name = "id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<dtoAllCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
