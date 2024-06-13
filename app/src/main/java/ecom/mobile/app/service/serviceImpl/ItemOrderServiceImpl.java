package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.ItemOrder;
import ecom.mobile.app.repository.ItemOrderRepository;
import ecom.mobile.app.service.serviceInterface.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {
    @Autowired
    ItemOrderRepository itemOrderRepository;

    @Override
    public List<ItemOrder> getItemOrderByRated(int userId, int isRated) {
        List<ItemOrder> itemOrders = itemOrderRepository.findByOrderUserIdAndIsRatedAndOrderStatus(userId, isRated,"Đã hoàn thành").orElse(
                new ArrayList<>());
        Collections.reverse(itemOrders);
        return itemOrders;
    }

    @Override
    public void updateItemOrderRated(int id, int stars) {
        itemOrderRepository.updateItemOrderRated(id, stars);
    }

}
