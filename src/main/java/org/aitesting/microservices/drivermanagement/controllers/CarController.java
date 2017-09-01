package org.aitesting.microservices.drivermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.aitesting.microservices.drivermanagement.models.Car;
import org.aitesting.microservices.drivermanagement.repositories.CarRepository;

import java.util.List;

@Controller
@RequestMapping("api")
public class CarController {
	
    @Autowired
    private CarRepository repository;

    @GetMapping("cars")
    public @ResponseBody List<Car> getCars(){
        return (List<Car>) repository.findAll();
    }

    @GetMapping("cars/find/{id}")
    public @ResponseBody Car getCar(@PathVariable("id") Integer id){
        return repository.findByIdcar(id);
    }
    
    @PostMapping("cars/add")
    public @ResponseBody Car addCar(@RequestBody Car car){
        repository.save(car);
        return car;
    }

    @PutMapping("cars/update/{id}")
    public @ResponseBody Car updateCar(@PathVariable("id") Integer id, @RequestBody Car updatedCar){
        Car car = repository.findByIdcar(id);
        car.setIdstate(updatedCar.getIdstate() != null ? updatedCar.getIdstate() : car.getIdstate());
        car.setIddriver(updatedCar.getIddriver() != null ? updatedCar.getIddriver()  : car.getIddriver());
        car.setIdmodel(updatedCar.getIdmodel() != null ? updatedCar.getIdmodel() : car.getIdmodel());
        car.setPlate(updatedCar.getPlate() != null ? updatedCar.getPlate() : car.getPlate());
        car.setImageUri(updatedCar.getImageUri() != null ? updatedCar.getImageUri() : car.getImageUri());
        car.setYear(updatedCar.getYear() != null ? updatedCar.getYear() : car.getYear());
        repository.save(car);

        return car;
    }

    @GetMapping("cars/delete/{id}")
    public @ResponseBody void deleteCar(@PathVariable("id") String id){
        repository.delete(id);
    }
}
