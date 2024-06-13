package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.User;
import ecom.mobile.app.repository.UserRepository;
import ecom.mobile.app.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByAccountEmail(String accountEmail) {
        return userRepository.findByAccountEmail(accountEmail);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }
}
