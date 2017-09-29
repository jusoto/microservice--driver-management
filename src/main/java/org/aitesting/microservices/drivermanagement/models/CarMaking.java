package org.aitesting.microservices.drivermanagement.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="car_making")
public class CarMaking {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idcar_making")
	private Integer idcarMaking;
	private String name;

    @OneToMany(mappedBy = "carMaking", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

	@JsonIgnore
	public Set<CarModel> getCarModels() {
		return carModels;
	}

	@Override
	public String toString() {
		return name;
	}

}
