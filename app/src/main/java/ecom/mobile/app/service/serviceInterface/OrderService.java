package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Order;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrder();

    List<Order> getOrdersByUserId(int uid);

    List<Order> getOrdersByUserIdAndStatus(int uid, String status);

    List<Order> getOrderByUserIdAndProductName(int uid, String productName);

    Order getOrderById(int oid);

    void updateOrderStatus(int oid, String status);

    List<Order> getAllOrdersWithPagination(int offset, int limit);

    List<Order> getAllOrdersSearchWithPagination(
            String key, Date startTime, Date endTime, String status, Pageable pageable);

    int getAllOrdersSearchWithPaginationNum(
            String key, Date startTime, Date endTime, String status);
}
