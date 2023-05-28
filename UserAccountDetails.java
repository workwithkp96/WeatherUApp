package com.weatherapp.WeatherUapp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserAccountDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="api_token")
	private String accessAPIToken;

	public UserAccountDetails(String firstName, String lastName, String accessAPIToken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accessAPIToken = accessAPIToken;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccessAPIToken() {
		return accessAPIToken;
	}

	public void setAccessAPIToken(String accessAPIToken) {
		this.accessAPIToken = accessAPIToken;
	}

	@Override
	public String toString() {
		return "UserAccountDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accessAPIToken=" + accessAPIToken + "]";
	}

}
