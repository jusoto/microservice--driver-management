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
@Table(name="driver_state")
public class DriverState {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="iddriver_state")
	private Integer iddriverState; // 1:Available 2:Busy 3:Suspended
	private String name;
	private String description;

    @OneToMany(mappedBy = "driverState", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HasDriverState> hasDriverStates;
	
	public DriverState() {
		
	}

	public Integer getIddriverState() {
		return iddriverState;
	}

	public void setIddriverState(Integer iddriverState) {
		this.iddriverState = iddriverState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
    public Set<HasDriverState> getHasDriverStates() {
		return hasDriverStates;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (iddriverState != null ? iddriverState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DriverState)) {
            return false;
        }
        DriverState other = (DriverState) object;
        if ((this.iddriverState == null && other.iddriverState != null) || (this.iddriverState != null && !this.iddriverState.equals(other.iddriverState))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return name;
	}

}
