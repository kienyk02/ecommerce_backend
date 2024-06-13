package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Account;

public interface AccountService {
    Account findByEmail(String email);

    boolean existsByEmail(String email);
}
