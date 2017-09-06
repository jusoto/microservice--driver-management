package org.aitesting.microservices.drivermanagement.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="has_driver_state")
public class HasDriverState {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idhas_driver_state")
	private Integer idhasDriverState;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddriver")
	private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcar")
	private Car car;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddriver_state")
	private DriverState driverState;
	private Date creationDate;
	
	public HasDriverState() {
		
	}

	public Integer getIdhasDriverState() {
		return idhasDriverState;
	}


	public void setIdhasDriverState(Integer idhasDriverState) {
		this.idhasDriverState = idhasDriverState;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public DriverState getDriverState() {
		return driverState;
	}


	public void setDriverState(DriverState driverState) {
		this.driverState = driverState;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	@Override
	public String toString() {
		return driver.toString() + " - " + car.toString() + " - " + driverState.toString() + " - " + creationDate.toString();
	}

}
