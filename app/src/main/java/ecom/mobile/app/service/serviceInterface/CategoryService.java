package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Category saveCategory(Category category);

    public List<Category> fetchAllCategory();

    public Optional<Category> fetchCategoryById(int id);

    public String deleteCategoryById(int id);
}
