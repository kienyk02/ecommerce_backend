package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Rate;
import ecom.mobile.app.repository.RateRepository;
import ecom.mobile.app.service.serviceInterface.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RateRepository rateRepository;
    @Override
    public Rate insertRate(Rate rate) {
        Rate rateExists=rateRepository.findByUserIdAndProductId(
                rate.getUser().getId(),
                rate.getProduct().getId()
        );
        if (rateExists != null){
            rateExists.setStars(rate.getStars());
            return rateRepository.save(rateExists);
        }
        return rateRepository.save(rate);
    }
}
