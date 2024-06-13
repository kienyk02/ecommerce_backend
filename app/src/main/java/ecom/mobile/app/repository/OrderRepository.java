package ecom.mobile.app.repository;

import ecom.mobile.app.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.user.id=:uid")
    Optional<List<Order>> getOrdersByUserId(int uid);

    Optional<List<Order>> findByUserIdAndStatus(int userId, String status);

    @Query("SELECT o FROM Order o JOIN o.itemOrders io WHERE o.user.id=:uid AND io.product.title LIKE %:productName%")
    List<Order> getOrderByUserIdAndProductName(int uid, String productName);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.status=:status WHERE o.id=:oid")
    void updateOrderStatus(int oid, String status);

    @Query("SELECT o FROM Order o order by o.id desc limit ?2 offset ?1")
    Optional<List<Order>> getAllOrdersWithPagination(int offset, int limit);

    @Query("SELECT DISTINCT o FROM Order o JOIN o.itemOrders io WHERE " +
            "(CAST(o.id AS string) LIKE %:key% " +
            "OR o.user.name LIKE %:key% " +
            "OR io.product.title LIKE %:key%) " +
            "AND (o.createTime BETWEEN:startTime AND :endTime) " +
            "AND o.status LIKE %:status% " +
            "order by o.id desc")
    Page<Order> getAllOrdersSearchWithPagination(
            String key, Date startTime, Date endTime, String status, Pageable pageable);

    @Query("SELECT DISTINCT o FROM Order o JOIN o.itemOrders io WHERE " +
            "(CAST(o.id AS string) LIKE %:key% " +
            "OR o.user.name LIKE %:key% " +
            "OR io.product.title LIKE %:key%) " +
            "AND (o.createTime BETWEEN:startTime AND :endTime) " +
            "AND o.status LIKE %:status% " +
            "order by o.id desc")
    Optional<List<Order>> getAllOrdersSearchWithPaginationNum(
            String key, Date startTime, Date endTime, String status);
}
