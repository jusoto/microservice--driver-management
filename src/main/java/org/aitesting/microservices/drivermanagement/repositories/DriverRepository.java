package org.aitesting.microservices.drivermanagement.repositories;

import org.aitesting.microservices.drivermanagement.models.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, String> {
	
    Driver findByIddriver(Integer id);
    
    public Iterable<Driver> findByActive(Integer active);
    
}
