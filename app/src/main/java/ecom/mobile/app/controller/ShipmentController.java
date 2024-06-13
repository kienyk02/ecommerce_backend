package ecom.mobile.app.controller;

import ecom.mobile.app.service.serviceInterface.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ShipmentController {
    @Autowired
    ShipmentService shipmentService;

    @PostMapping("/shipment/update/{shipment_id}")
    public void updateShipmentStatus(
            @PathVariable("shipment_id") int shipment_id,
            @RequestBody String status
    ) {
        shipmentService.updateShipmentStatus(shipment_id, status);
    }
}
