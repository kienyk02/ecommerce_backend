package ecom.mobile.app.service.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ecom.mobile.app.model.Product;
import ecom.mobile.app.repository.ProductRepository;
import ecom.mobile.app.service.serviceInterface.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(String productString, MultipartFile image) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(productString, Product.class);

        product.setImage(image.getBytes());

        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> fetchProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByTitleOrAuthorLike(keyword);
    }

    @Override
    public List<Product> fetchProductsByType(int id) {
        return productRepository.findByTypeIs(id);
    }

    @Override
    public String deleteProductById(int id) {
        productRepository.deleteById(id);
        return "Product with id " + id + " deleted successfully";
    }

    @Override
    public Product updateProduct(int id, String productString, MultipartFile image) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(productString, Product.class);

        Product productDb = productRepository.findById(id).orElse(null);

        assert productDb != null;

        if (Objects.nonNull(product.getTitle()) &&
                !"".equalsIgnoreCase(product.getTitle())) {
            productDb.setTitle(product.getTitle());
        }

        if (Objects.nonNull(product.getAuthor()) &&
                !"".equalsIgnoreCase(product.getAuthor())) {
            productDb.setAuthor(product.getAuthor());
        }

        if (Objects.nonNull(product.getDescription()) &&
                !"".equalsIgnoreCase(product.getDescription())) {
            productDb.setDescription(product.getDescription());
        }

        if (product.getPrice() != 0) {
            productDb.setPrice(product.getPrice());
        }

        if (productDb.getType() != product.getType()) {
            productDb.setType(product.getType());
        }

        if (Objects.nonNull(product.getCategories())) {
            productDb.setCategories(product.getCategories());
        }

        if (Objects.nonNull(image)) {
            productDb.setImage(image.getBytes());
        }

        return productRepository.save(productDb);
    }

    @Override
    public List<Product> fetchProductsFilterByCategoriesAndPrice(List<Integer> categoryIds, int listCount, int price) {
        return productRepository.findProductsFilterByCategories(categoryIds, listCount, price);
    }

    @Override
    public List<Product> fetchProductsByTypeWithSize(int id, int quantity) {
        return productRepository.fetchProductsByTypeWithSize(id, quantity);
    }

    @Override
    public List<Product> fetchProductsFilterByCategoriesAndPriceAndType(int typeId, List<Integer> categoryIds, int listCount, int price) {
        return productRepository.findProductsFilterByCategoriesAndType(typeId, categoryIds, listCount, price);
    }

}
