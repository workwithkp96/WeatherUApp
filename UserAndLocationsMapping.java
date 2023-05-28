package com.weatherapp.WeatherUapp.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class UserAndLocationsMapping {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="locations")
	private List<String> locations;

	public UserAndLocationsMapping(int id, List<String> locations) {
		super();
		this.id=id;
		this.locations = locations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "UserAndLocationsMapping [id=" + id + ", locations=" + locations + "]";
	}
	
	

}
