package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Cart;
import ecom.mobile.app.repository.CartRepository;
import ecom.mobile.app.service.serviceInterface.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cart) {
        Cart cartExists = cartRepository.findByProductIdAndUserId(
                cart.getProduct().getId(),
                cart.getUser().getId()
        );
        if (cartExists != null) {
            cartExists.setQuantity(cartExists.getQuantity() + cart.getQuantity());
            return cartRepository.save(cartExists);
        }
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartsByUserId(int uid) {
        List<Cart> carts=cartRepository.getCartsByUserId(uid);
        Collections.reverse(carts);
        return carts;
    }

    @Override
    public void updateCartQuantity(int cid, int quantity) {
        cartRepository.updateCartQuantity(cid, quantity);
    }

    @Override
    public void deleteCartById(int cid) {
        cartRepository.deleteById(cid);
    }

    @Override
    public void deleteCartByUserId(int uid) {
        cartRepository.deleteCartByUserId(uid);
    }
}
