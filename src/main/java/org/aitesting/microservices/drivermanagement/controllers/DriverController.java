package org.aitesting.microservices.drivermanagement.controllers;

import org.aitesting.microservices.drivermanagement.models.Driver;
import org.aitesting.microservices.drivermanagement.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class DriverController {
	
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("drivers")
    public @ResponseBody Iterable<Driver> getDrivers(){
    	// 1="Active", 0="Not Active"
        return  driverRepository.findByActive(1);
    }

    @GetMapping("drivers/{id}")
    public @ResponseBody Driver getDriver(@PathVariable("id") Integer id){
        return driverRepository.findByIddriver(id);
    }

    @PostMapping("drivers/add")
    public @ResponseBody Driver addDriver(@RequestBody Driver driver){
        driverRepository.save(driver);
        return driver;
    }

    @PutMapping("drivers/update/{id}")
    public @ResponseBody Driver updateDriver(@PathVariable("id") Integer id, @RequestBody Driver updatedDriver){
        Driver driver = driverRepository.findByIddriver(id);
        driver.setFname(updatedDriver.getFname() != null ? updatedDriver.getFname() : driver.getFname());
        driver.setLname(updatedDriver.getLname() != null ? updatedDriver.getLname()  : driver.getLname());
        driver.setUsername(updatedDriver.getUsername() != null ? updatedDriver.getUsername() : driver.getUsername());
        driver.setCity(updatedDriver.getCity() != null ? updatedDriver.getCity() : driver.getCity());
        driver.setEmail(updatedDriver.getEmail() != null ? updatedDriver.getEmail() : driver.getEmail());
        driver.setPhone(updatedDriver.getPhone() != null ? updatedDriver.getPhone() : driver.getPhone());
        driver.setAddress(updatedDriver.getAddress() != null ? updatedDriver.getAddress() : driver.getAddress());
        driver.setActive(updatedDriver.getActive() != null ? updatedDriver.getActive() : driver.getActive());
        driver.setLastLocationLat(updatedDriver.getLastLocationLat() != null ? updatedDriver.getLastLocationLat() : updatedDriver.getLastLocationLat());
        driver.setLastLocationLon(updatedDriver.getLastLocationLon() != null ? updatedDriver.getLastLocationLon() : updatedDriver.getLastLocationLon());
        driverRepository.save(driver);
        return driver;
    }
    
    @PutMapping("drivers/update/location/{id}")
    public @ResponseBody Driver updateDriverLocation(@PathVariable("id") Integer id, @RequestParam Double lat, @RequestParam Double lon){
        Driver driver = driverRepository.findByIddriver(id);
        driver.setLastLocationLat(lat != null ? lat : driver.getLastLocationLat());
        driver.setLastLocationLon(lon != null ? lon : driver.getLastLocationLon());
        driverRepository.save(driver);

        return driver;
    }

    @GetMapping("drivers/delete/{id}")
    public @ResponseBody void deleteDriver(@PathVariable("id") String id){
        driverRepository.delete(id);
    }
}
