package org.aitesting.microservices.drivermanagement.repositories;

import org.aitesting.microservices.drivermanagement.models.DriverState;
import org.springframework.data.repository.CrudRepository;

public interface DriverStateRepository  extends CrudRepository<DriverState, String> {
	
    DriverState findByIddriverState(Integer id);

}
