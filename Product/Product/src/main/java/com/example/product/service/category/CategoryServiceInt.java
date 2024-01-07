package com.example.product.service.category;

import com.example.product.dto.category.CategoryRequest;
import com.example.product.dto.category.CategoryResponse;
import com.example.product.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryServiceInt {

    public CategoryResponse addCategory(CategoryRequest category);
    public CategoryResponse editCategory(CategoryRequest category, Integer idCategory);
    public String deleteCategory(Integer idCategory);
    public List<Category> getAllCategory();

}
