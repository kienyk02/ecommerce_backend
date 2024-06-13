package ecom.mobile.app.controller;

import ecom.mobile.app.service.serviceInterface.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment/update/{payment_id}")
    public void updatePaymentStatus(
            @PathVariable("payment_id") int payment_id,
            @RequestBody String paymentStatus
    ) {
        paymentService.updatePaymentStatus(payment_id, paymentStatus);
    }
}
