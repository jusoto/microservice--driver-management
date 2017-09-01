package org.aitesting.microservices.drivermanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idcar")
	private Integer idcar;
	private Integer idstate;
	private Integer iddriver;
	private Integer idmodel;
	private String plate;
	private String imageUri;
	private Integer year;
	
	public Car() {
		
	}

	public Car(Integer idstate, Integer iddriver, Integer idmodel, String plate, String imageUri, Integer year) {
		super();
		this.idstate = idstate;
		this.iddriver = iddriver;
		this.idmodel = idmodel;
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

	public Integer getIdstate() {
		return idstate;
	}

	public void setIdstate(Integer idstate) {
		this.idstate = idstate;
	}

	public Integer getIddriver() {
		return iddriver;
	}

	public void setIddriver(Integer iddriver) {
		this.iddriver = iddriver;
	}

	public Integer getIdmodel() {
		return idmodel;
	}

	public void setIdmodel(Integer idmodel) {
		this.idmodel = idmodel;
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

}
