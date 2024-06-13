package ecom.mobile.app.repository;

import ecom.mobile.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByAccountEmail(String accountEmail);
}
