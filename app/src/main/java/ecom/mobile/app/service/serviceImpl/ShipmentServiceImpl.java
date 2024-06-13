package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Shipment;
import ecom.mobile.app.repository.ShipmentRepository;
import ecom.mobile.app.service.serviceInterface.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Autowired
    ShipmentRepository shipmentRepository;

    @Override
    public void updateShipmentStatus(int shipment_id, String status) {
        Shipment shipment = shipmentRepository.findById(shipment_id).orElse(null);
        if (shipment != null) {
            shipment.setShipStatus(status);
            shipmentRepository.save(shipment);
        }
    }
}
