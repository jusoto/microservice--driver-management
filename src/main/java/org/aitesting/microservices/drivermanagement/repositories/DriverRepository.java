package org.aitesting.microservices.drivermanagement.repositories;

import org.aitesting.microservices.drivermanagement.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, String> {
	
    Driver findByIddriver(Integer id);
    
    public Iterable<Driver> findByActive(Integer active);
    
    public Iterable<Driver> findByLastLocationLat(Double latitude);
    
}
