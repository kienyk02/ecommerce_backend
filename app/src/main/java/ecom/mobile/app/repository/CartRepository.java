package ecom.mobile.app.repository;

import ecom.mobile.app.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT c FROM Cart c WHERE c.user.id=:uid")
    List<Cart> getCartsByUserId(int uid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Cart c SET c.quantity=:quantity WHERE c.id=:cid")
    void updateCartQuantity(int cid, int quantity);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cart c WHERE c.user.id=:uid")
    void deleteCartByUserId(int uid);

    Cart findByProductIdAndUserId(int productId, int userId);

}
