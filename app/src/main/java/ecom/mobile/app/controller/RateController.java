package ecom.mobile.app.controller;

import ecom.mobile.app.model.Rate;
import ecom.mobile.app.model.User;
import ecom.mobile.app.security.CustomUserDetails;
import ecom.mobile.app.service.serviceInterface.RateService;
import ecom.mobile.app.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RateController {
    @Autowired
    RateService rateService;
    @Autowired
    UserService userService;

    private User getUserRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return userService.findByAccountEmail(customUserDetails.getEmail());
    }

    @PostMapping("/insert-rate")
    public Rate insertRate(@RequestBody Rate rate){
        rate.setUser(getUserRequest());
        return rateService.insertRate(rate);
    }
}
