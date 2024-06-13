package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Payment;
import ecom.mobile.app.repository.PaymentRepository;
import ecom.mobile.app.service.serviceInterface.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void updatePaymentStatus(int payment_id, String status) {
        Payment payment = paymentRepository.findById(payment_id).orElse(null);
        if (payment != null) {
            payment.setPayStatus(status);
            paymentRepository.save(payment);
        }
    }
}
