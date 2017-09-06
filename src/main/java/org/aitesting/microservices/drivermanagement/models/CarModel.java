package org.aitesting.microservices.drivermanagement.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="car_model")
public class CarModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idcar_model")
	private Integer idcarModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcar_making")
	private CarMaking making;
	private String name;

    @OneToMany
    private Set<Car> cars;
	
	public CarModel() {
		
	}

	public Integer getIdcarModel() {
		return idcarModel;
	}

	public void setIdcarModel(Integer idcarModel) {
		this.idcarModel = idcarModel;
	}

	public CarMaking getMaking() {
		return making;
	}

	public void setMaking(CarMaking making) {
		this.making = making;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Car> getCars() {
		return cars;
	}

	@Override
	public String toString() {
		return name;
	}

}
