package org.aitesting.microservices.drivermanagement.controllers;

import org.aitesting.microservices.drivermanagement.models.HasDriverState;
import org.aitesting.microservices.drivermanagement.repositories.HasDriverStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class HasDriverStateController {
	
    @Autowired
    private HasDriverStateRepository repository;

    @GetMapping("has_driver_state")
    public @ResponseBody Iterable<HasDriverState> getHasDriverStates(){
    	// 1="Active", 0="Not Active"
        return  repository.findAll();
    }

    @GetMapping("has_driver_state/{id}")
    public @ResponseBody HasDriverState getHasDriverState(@PathVariable("id") Integer id){
        return repository.findByIdhasDriverState(id);
    }

    @GetMapping("has_driver_state/last/{id}")
    public @ResponseBody HasDriverState getLastByDriver(@PathVariable("id") Integer id){
        return repository.findLastByDriver(id);
    }

    @PostMapping("has_driver_state/add")
    public @ResponseBody HasDriverState addHasDriverState(@RequestBody HasDriverState driver){
        repository.save(driver);
        return driver;
    }

    @PutMapping("has_driver_state/update/{id}")
    public @ResponseBody HasDriverState updateHasDriverState(@PathVariable("id") Integer id, @RequestBody HasDriverState updatedHasDriverState){
        HasDriverState driver = repository.findByIdhasDriverState(id);
        driver.setDriver(updatedHasDriverState.getDriver() != null ? updatedHasDriverState.getDriver() : driver.getDriver());
        driver.setCar(updatedHasDriverState.getCar() != null ? updatedHasDriverState.getCar()  : driver.getCar());
        driver.setDriverState(updatedHasDriverState.getDriverState() != null ? updatedHasDriverState.getDriverState() : driver.getDriverState());
        repository.save(driver);
        return driver;
    }

    @GetMapping("has_driver_state/delete/{id}")
    public @ResponseBody void deleteHasDriverState(@PathVariable("id") String id){
        repository.delete(id);
    }
}
