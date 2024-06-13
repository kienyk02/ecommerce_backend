package ecom.mobile.app.controller;

import ecom.mobile.app.model.Cart;
import ecom.mobile.app.model.User;
import ecom.mobile.app.security.CustomUserDetails;
import ecom.mobile.app.service.serviceInterface.CartService;
import ecom.mobile.app.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;

    private User getUserRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return userService.findByAccountEmail(customUserDetails.getEmail());
    }

    @PostMapping("/add-cart")
    public Cart addCart(@RequestBody Cart cart) {
        User currentUser = getUserRequest();
        User userCart = new User();
        userCart.setId(currentUser.getId());
        cart.setUser(userCart);
        return cartService.addCart(cart);
    }

    @GetMapping("/carts")
    public List<Cart> getCartsByUser() {
        List<Cart> carts = cartService.getCartsByUserId(getUserRequest().getId());
        return carts != null ? carts : new ArrayList<>();
    }

    @PostMapping("/cart/update/{cart_id}")
    public void updateCartQuantity(
            @PathVariable("cart_id") int cart_id,
            @RequestParam("quantity") int quantity
    ) {
        cartService.updateCartQuantity(cart_id, quantity);
    }

    @DeleteMapping("/cart/delete/{cart_id}")
    public void deleteCartById(@PathVariable("cart_id") int cart_id) {
        cartService.deleteCartById(cart_id);
    }

    @DeleteMapping("/cart/delete-all")
    public void deleteCartByUser() {
        cartService.deleteCartByUserId(getUserRequest().getId());
    }

}
