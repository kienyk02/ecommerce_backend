package ecom.mobile.app.controller;

import ecom.mobile.app.model.ItemOrder;
import ecom.mobile.app.model.User;
import ecom.mobile.app.security.CustomUserDetails;
import ecom.mobile.app.service.serviceInterface.ItemOrderService;
import ecom.mobile.app.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ItemOrderController {
    @Autowired
    ItemOrderService itemOrderService;

    @Autowired
    UserService userService;

    private User getUserRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return userService.findByAccountEmail(customUserDetails.getEmail());
    }

    @GetMapping("/item-order-rated")
    public List<ItemOrder> getItemOrderByRated(){
        return itemOrderService.getItemOrderByRated(getUserRequest().getId(),0);
    }

    @PostMapping("/item-order-rated/{id}/{stars}")
    public void updateItemOrderByRated(@PathVariable("id") int id, @PathVariable("stars") int stars){
        itemOrderService.updateItemOrderRated(id, stars);
    }

}
