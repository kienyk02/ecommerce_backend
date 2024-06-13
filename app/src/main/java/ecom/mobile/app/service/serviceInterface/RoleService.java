package ecom.mobile.app.service.serviceInterface;


import ecom.mobile.app.model.ERole;
import ecom.mobile.app.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(ERole roleName);
}
