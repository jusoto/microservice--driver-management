package org.aitesting.microservices.drivermanagement.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="has_driver_state")
public class HasDriverState {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idhas_driver_state")
	private Integer idhasDriverState;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddriver", referencedColumnName = "iddriver")
	private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcar", referencedColumnName = "idcar")
	private Car car;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddriver_state", referencedColumnName = "iddriver_state")
	private DriverState driverState;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
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
    public int hashCode() {
        int hash = 0;
        hash += (idhasDriverState != null ? idhasDriverState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasDriverState)) {
            return false;
        }
        HasDriverState other = (HasDriverState) object;
        if ((this.idhasDriverState == null && other.idhasDriverState != null) || (this.idhasDriverState != null && !this.idhasDriverState.equals(other.idhasDriverState))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return driver.toString() + " - " + car.toString() + " - " + driverState.toString() + " - " + creationDate.toString();
	}

}
