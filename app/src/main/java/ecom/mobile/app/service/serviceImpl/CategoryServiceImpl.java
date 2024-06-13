package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Category;
import ecom.mobile.app.repository.CategoryRepository;
import ecom.mobile.app.service.serviceInterface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> fetchAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> fetchCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public String deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
        return "Category with id = " + id + " deleted successfully";
    }

}
