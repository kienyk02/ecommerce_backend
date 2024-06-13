package ecom.mobile.app.controller;

import ecom.mobile.app.model.Category;
import ecom.mobile.app.service.serviceInterface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> fetchAllCategory() {
        return categoryService.fetchAllCategory();
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> fetchCategoryById(@PathVariable int id) {
        return categoryService.fetchCategoryById(id);
    }

    @DeleteMapping("categories/{id}")
    public String deleteCategoryById(@PathVariable int id) {
        return categoryService.deleteCategoryById(id);
    }

}
