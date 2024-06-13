package ecom.mobile.app.service.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import ecom.mobile.app.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product saveProduct(String productString, MultipartFile image) throws IOException;

    public List<Product> fetchAllProducts();

    public Optional<Product> fetchProductById(int id);

    public List<Product> searchProducts(String keyword);

    public List<Product> fetchProductsByType(int id);

    public String deleteProductById(int id);

    public Product updateProduct(int id, String productString, MultipartFile image) throws IOException;

    public List<Product> fetchProductsFilterByCategoriesAndPrice(List<Integer> categoryIds, int listCount, int price);

    public List<Product> fetchProductsByTypeWithSize(int id, int quantity);

    public List<Product> fetchProductsFilterByCategoriesAndPriceAndType(int typeId, List<Integer> categoryIds, int listCount, int price);

}
