package com.weatherapp.WeatherUapp.Entity;

import java.util.List;

public interface UserAccountDetailsDAO {
	public UserAccountDetails saveAccount(UserAccountDetails useraccountdetails);
	public UserAccountDetails findbyID(int id);
	public List<UserAccountDetails> findAll();
	public UserAccountDetails findbyName(String fristName, String LastName);
	public void updateAccessToken(int id, String AccessToken);
	public void deletebyID(int id);
	public String getAccessToken(int id);
}
