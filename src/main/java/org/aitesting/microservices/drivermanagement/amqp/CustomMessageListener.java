package org.aitesting.microservices.drivermanagement.amqp;

import org.aitesting.microservices.drivermanagement.DriverManagementApplication;
import org.aitesting.microservices.drivermanagement.models.HasDriverState;
import org.aitesting.microservices.drivermanagement.repositories.DriverRepository;
import org.aitesting.microservices.drivermanagement.repositories.DriverStateRepository;
import org.aitesting.microservices.drivermanagement.repositories.HasDriverStateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);
    
    @Autowired
    private HasDriverStateRepository hasDriverStateRepository;
    
    @Autowired
    private DriverStateRepository driverStateRepository;
    
    @Autowired
    private DriverRepository driverRepository;

//    @RabbitListener(queues = DriverManagementApplication.QUEUE_GENERIC_NAME)
//    public void receiveMessage(final Message message) {
//        log.info("Received message as generic: {}", message.toString());
//    }

    @RabbitListener(queues = DriverManagementApplication.DRIVER_MANAGEMENT_QUEUE)
    public void receiveMessage(final CustomMessage customMessage) {
    	HasDriverState obj = new HasDriverState();
    	obj.setDriver(driverRepository.findByIddriver(customMessage.getIddriver()));
    	obj.setDriverState(driverStateRepository.findByIddriverState(customMessage.getIddriverState()));
    	hasDriverStateRepository.save(obj);
        log.info("Received Driver message as specific class: {}", customMessage.toString());
    }
}
