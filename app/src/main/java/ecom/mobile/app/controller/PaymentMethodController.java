package ecom.mobile.app.controller;

import ecom.mobile.app.model.PaymentMethod;
import ecom.mobile.app.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PaymentMethodController {
    @Autowired
    PaymentMethodRepository paymentMethodRepository;
    @GetMapping("/paymentmethods")
    public List<PaymentMethod> getAll(){
        return paymentMethodRepository.findAll();
    }
}
