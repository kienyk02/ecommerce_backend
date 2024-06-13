package ecom.mobile.app.repository;

import ecom.mobile.app.model.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder,Integer> {
    Optional<List<ItemOrder>> findByOrderUserIdAndIsRatedAndOrderStatus(int orderUserId, int isRated, String orderStatus);

    @Modifying
    @Transactional
    @Query("UPDATE ItemOrder io SET io.isRated=1, io.stars=:stars WHERE io.id=:id")
    void updateItemOrderRated(int id, int stars);


}
