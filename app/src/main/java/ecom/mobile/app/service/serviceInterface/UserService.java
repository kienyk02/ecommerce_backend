package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.User;

import java.util.Optional;

public interface UserService {
    User findByAccountEmail(String accountEmail);

    Optional<User> getUserById(int id);

    void saveOrUpdate(User user);

}
