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
@Table(name="driver_state")
public class DriverState {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="iddriver_state")
	private Integer iddriverState;
	private String name;
	private String description;

    @OneToMany
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

	@Override
	public String toString() {
		return name;
	}

}
