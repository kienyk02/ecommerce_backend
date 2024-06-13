package ecom.mobile.app.repository;

import ecom.mobile.app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Address a SET a.address=:address WHERE a.user.id=:userId")
    void updateAddressByUserId(String address, int userId);
}
