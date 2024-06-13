package ecom.mobile.app.repository;

import ecom.mobile.app.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
    Rate findByUserIdAndProductId(int userId, int productId);
}
