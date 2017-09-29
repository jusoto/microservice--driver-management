package org.aitesting.microservices.drivermanagement.models;

import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="car_model")
public class CarModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idcar_model")
	private Integer idcarModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcar_making", referencedColumnName = "idcar_making")
	private CarMaking carMaking;
	private String name;

    @OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Car> cars;
	
	public CarModel() {
		
	}

	public Integer getIdcarModel() {
		return idcarModel;
	}

	public void setIdcarModel(Integer idcarModel) {
		this.idcarModel = idcarModel;
	}

	public CarMaking getCarMaking() {
		return carMaking;
	}

	public void setCarMaking(CarMaking carMaking) {
		this.carMaking = carMaking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Set<Car> getCars() {
		return cars;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarModel != null ? idcarModel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarModel)) {
            return false;
        }
        CarModel other = (CarModel) object;
        if ((this.idcarModel == null && other.idcarModel != null) || (this.idcarModel != null && !this.idcarModel.equals(other.idcarModel))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return name;
	}

}
