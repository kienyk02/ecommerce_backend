package ecom.mobile.app.repository;

import ecom.mobile.app.model.ShipmentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentMethodRepository extends JpaRepository<ShipmentMethod,Integer> {
}
