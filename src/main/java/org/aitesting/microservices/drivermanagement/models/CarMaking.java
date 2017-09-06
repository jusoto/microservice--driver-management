package org.aitesting.microservices.drivermanagement.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="car_making")
public class CarMaking {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idcar_making")
	private Integer idcarMaking;
	private String name;

    @OneToMany
    private Set<CarModel> carModels;
	
	public CarMaking() {
		
	}

	public Integer getIdcarMaking() {
		return idcarMaking;
	}

	public void setIdcarMaking(Integer idcarMaking) {
		this.idcarMaking = idcarMaking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CarModel> getCarModels() {
		return carModels;
	}

	@Override
	public String toString() {
		return name;
	}

}
