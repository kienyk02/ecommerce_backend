package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.ItemOrder;

import java.util.List;

public interface ItemOrderService {
    List<ItemOrder> getItemOrderByRated(int userId, int isRated);

    void updateItemOrderRated(int id, int stars);
}
