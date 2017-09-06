package org.aitesting.microservices.drivermanagement.repositories;

import org.aitesting.microservices.drivermanagement.models.HasDriverState;
import org.springframework.data.repository.CrudRepository;

public interface HasDriverStateRepository extends CrudRepository<HasDriverState, String> {
	
    HasDriverState findByIdhasDriverState(Integer id);
    
    HasDriverState findLastByDriver(Integer id);
    
}
