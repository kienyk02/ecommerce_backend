package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Account;
import ecom.mobile.app.repository.AccountRepository;
import ecom.mobile.app.service.serviceInterface.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }
}
