package com.example.product.controller;

import com.example.product.dto.category.CategoryRequest;
import com.example.product.dto.category.CategoryResponse;
import com.example.product.model.Category;
import com.example.product.service.category.CategoryService;
import com.example.product.service.category.CategoryServiceInt;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin

public class CategoryController {

    private final CategoryServiceInt categoryServiceInt;

    public CategoryController(CategoryService categoryService, CategoryServiceInt categoryServiceInt) {
        this.categoryServiceInt = categoryServiceInt;
    }

    @PostMapping
    public CategoryResponse addCategory(@RequestBody CategoryRequest category) throws Exception
    {
        System.out.println("Ajungem aicii");
        return categoryServiceInt.addCategory(category);
    }

    @PutMapping
    public CategoryResponse editCategory(@RequestBody CategoryRequest category, @RequestParam @NotNull Integer idCategory){
        return  categoryServiceInt.editCategory(category, idCategory);
    }

    @DeleteMapping
    public String deleteCategory(@RequestParam Integer idCategory){
        return categoryServiceInt.deleteCategory(idCategory);
    }

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryServiceInt.getAllCategory();
    }


}
