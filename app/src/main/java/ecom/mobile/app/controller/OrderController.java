package ecom.mobile.app.controller;

import ecom.mobile.app.model.Cart;
import ecom.mobile.app.model.ItemOrder;
import ecom.mobile.app.model.Order;
import ecom.mobile.app.model.User;
import ecom.mobile.app.security.CustomUserDetails;
import ecom.mobile.app.service.serviceInterface.OrderService;
import ecom.mobile.app.service.serviceInterface.PaymentService;
import ecom.mobile.app.service.serviceInterface.ShipmentService;
import ecom.mobile.app.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    ShipmentService shipmentService;

    private User getUserRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return userService.findByAccountEmail(customUserDetails.getEmail());
    }

    @PostMapping("/create-order")
    public Order createOrder(@RequestBody Order order) {
        order.setUser(getUserRequest());
        order.getItemOrders().forEach(itemOrder ->
                itemOrder.setOrder(order));
        return orderService.createOrder(order);
    }

    @GetMapping("/admin/order-all")
    public List<Order> getAllOrdersSearchWithPagination(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit,
            @RequestParam("key") String key,
            @RequestParam("startTime") String startTimeStr,
            @RequestParam("endTime") String endTimeStr,
            @RequestParam("status") String status){
        Date startTime = parseDate(startTimeStr);
        Date endTime = parseDate(endTimeStr);
        Pageable pageable = PageRequest.of(page-1, limit);
        return orderService.getAllOrdersSearchWithPagination(
                key,
                startTime,
                endTime,
                status,
                pageable);
    }

    @GetMapping("/admin/order-all-num")
    public int getAllOrdersSearchWithPaginationNum(
            @RequestParam("key") String key,
            @RequestParam("startTime") String startTimeStr,
            @RequestParam("endTime") String endTimeStr,
            @RequestParam("status") String status){
        Date startTime = parseDate(startTimeStr);
        Date endTime = parseDate(endTimeStr);
        return orderService.getAllOrdersSearchWithPaginationNum(
                key,
                startTime,
                endTime,
                status);
    }


    @GetMapping("/order-all")
    public List<Order> getOrdersByUser() {
        return orderService.getOrdersByUserId(getUserRequest().getId());
    }

    @GetMapping("/orders")
    public List<Order> getOrdersByUserAndStatus(@RequestParam("status") String status) {
        return orderService.getOrdersByUserIdAndStatus(
                getUserRequest().getId(),
                status
        );
    }

    @GetMapping("/orders/search")
    public List<Order> getOrdersByUserAndProductName(@RequestParam("key") String productName) {
        return orderService.getOrderByUserIdAndProductName(
                getUserRequest().getId(),
                productName
        );
    }

    @GetMapping("/order/get/{order_id}")
    public Order getOrderById(@PathVariable("order_id") int order_id) {
        return orderService.getOrderById(order_id);
    }

    @PostMapping("/order/update/{order_id}")
    void updateOrderStatus(@PathVariable("order_id") int order_id, @RequestBody String status) {
        Order order=orderService.getOrderById(order_id);
        shipmentService.updateShipmentStatus(order.getShipment().getId(),"Giao hàng thành công");
        paymentService.updatePaymentStatus(order.getPayment().getId(),"Đã thanh toán");
        orderService.updateOrderStatus(order_id, status);
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            // Xử lý ngoại lệ khi không thể chuyển đổi
            return null;
        }
    }
}
