package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Cart;

import java.util.List;

public interface CartService {
    public Cart addCart(Cart cart);

    public List<Cart> getCartsByUserId(int uid);

    public void updateCartQuantity(int cid, int quantity);

    public void deleteCartById(int cid);

    public void deleteCartByUserId(int uid);

}
