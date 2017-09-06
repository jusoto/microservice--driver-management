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
@Table(name="driver")
public class Driver {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="iddriver")
	private Integer iddriver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcity")
	private City city;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String email;
	private Double lastLocationLat;
	private Double lastLocationLon;
	private String address;
	private String phone;
	private Integer active; // 1 = active, 0 = inactive

    @OneToMany
    private Set<Car> cars;

    @OneToMany
    private Set<HasDriverState> hasDriverStates;
	
	public Driver() {
		
	}

	public Driver(City city, String fname, String lname, String username, String password, String email,
			Double lastLocationLat, Double lastLocationLon, String address, String phone, Integer active) {
		super();
		this.city = city;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.lastLocationLat = lastLocationLat;
		this.lastLocationLon = lastLocationLon;
		this.address = address;
		this.phone = phone;
		this.active = active;
	}

	public Integer getIddriver() {
		return iddriver;
	}

	public void setIddriver(Integer iddriver) {
		this.iddriver = iddriver;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getLastLocationLat() {
		return lastLocationLat;
	}

	public void setLastLocationLat(Double lastLocationLat) {
		this.lastLocationLat = lastLocationLat;
	}

	public Double getLastLocationLon() {
		return lastLocationLon;
	}

	public void setLastLocationLon(Double lastLocationLon) {
		this.lastLocationLon = lastLocationLon;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return fname + " " + lname;
	}

}
