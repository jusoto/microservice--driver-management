package org.aitesting.microservices.drivermanagement.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idcar;
    @ManyToOne
    @JoinColumn(name = "idstate")
	private State state;
    @ManyToOne
    @JoinColumn(name = "iddriver")
	private Driver driver;
    @ManyToOne
    @JoinColumn(name = "idcar_model")
	private CarModel carModel;
	private String plate;
	private String imageUri;
	private Integer year;

    @OneToMany
    private Set<HasDriverState> hasDriverStates;
	
	public Car() {
		
	}

	public Car(State state, Driver driver, CarModel carModel, String plate, String imageUri, Integer year) {
		super();
		this.state = state;
		this.driver = driver;
		this.carModel = carModel;
		this.plate = plate;
		this.imageUri = imageUri;
		this.year = year;
	}

	public Integer getIdcar() {
		return idcar;
	}

	public void setIdcar(Integer idcar) {
		this.idcar = idcar;
	}


	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return plate;
	}

}
