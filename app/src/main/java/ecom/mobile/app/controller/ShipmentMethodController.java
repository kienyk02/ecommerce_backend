package ecom.mobile.app.controller;

import ecom.mobile.app.model.ShipmentMethod;
import ecom.mobile.app.repository.ShipmentMethodRepository;
import ecom.mobile.app.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ShipmentMethodController {
    @Autowired
    ShipmentMethodRepository shipmentMethodRepository;

    @GetMapping("/shipmentmethods")
    public List<ShipmentMethod> getAll(){
        return shipmentMethodRepository.findAll();
    }
}
