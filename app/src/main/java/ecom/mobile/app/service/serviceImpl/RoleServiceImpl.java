package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.ERole;
import ecom.mobile.app.model.Role;
import ecom.mobile.app.repository.RoleRepository;
import ecom.mobile.app.service.serviceInterface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> findByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }

}
