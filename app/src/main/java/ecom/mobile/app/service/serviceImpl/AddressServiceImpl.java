package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Address;
import ecom.mobile.app.repository.AddressRepository;
import ecom.mobile.app.service.serviceInterface.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void updateAddress(String address, int userId) {
        addressRepository.updateAddressByUserId(address, userId);
    }
}
