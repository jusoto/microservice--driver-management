package org.aitesting.microservices.drivermanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import org.aitesting.microservices.drivermanagement.models.Car;

public interface CarRepository extends CrudRepository<Car, String> {
	
    Car findByIdcar(Integer id);
}
