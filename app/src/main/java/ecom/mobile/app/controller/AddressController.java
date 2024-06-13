package ecom.mobile.app.controller;

import ecom.mobile.app.model.User;
import ecom.mobile.app.payload.response.MessageResponse;
import ecom.mobile.app.security.CustomUserDetails;
import ecom.mobile.app.service.serviceInterface.AddressService;
import ecom.mobile.app.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    private User getUserRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return userService.findByAccountEmail(customUserDetails.getEmail());
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/address/update")
    public MessageResponse updateAddress(@RequestParam("address") String address){
        addressService.updateAddress(address, getUserRequest().getId());
        return new MessageResponse("Cập nhật địa chỉ thành công!");
    }


}
