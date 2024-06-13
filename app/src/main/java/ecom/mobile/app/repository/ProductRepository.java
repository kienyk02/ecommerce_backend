package ecom.mobile.app.repository;

import ecom.mobile.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.title LIKE %:keyword% OR p.author LIKE %:keyword%")
    public List<Product> findByTitleOrAuthorLike(String keyword);

    public List<Product> findByTypeIs(int id);

    @Query("SELECT p FROM Product p " +
            "JOIN p.categories c " +
            "WHERE c.id IN ?1 " +
            "GROUP BY p " +
            "HAVING COUNT(DISTINCT c) = ?2 AND p.price < ?3 ")
    public List<Product> findProductsFilterByCategories(List<Integer> categoryIds, int listCount, int price);

    @Query(
            value = "SELECT * from product p WHERE p.type = ?1 LIMIT ?2",
            nativeQuery = true
    )
    public List<Product> fetchProductsByTypeWithSize(int id, int quantity);

    @Query("SELECT p FROM Product p " +
            "JOIN p.categories c " +
            "WHERE c.id IN ?2 " +
            "GROUP BY p " +
            "HAVING COUNT(DISTINCT c) = ?3 AND p.price < ?4 AND p.type = ?1")
    public List<Product> findProductsFilterByCategoriesAndType(int typeId, List<Integer> categoryIds, int listCount, int price);

}
