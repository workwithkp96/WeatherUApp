package com.weatherapp.WeatherUapp.Service;

import java.util.List;

import com.weatherapp.WeatherUapp.Entity.UserAndLocationsMapping;

public interface UserAndLocationsMappingService {
	public void saveLocations(UserAndLocationsMapping userandlocationsmapping);
	public void deleteLocations(int id);
	public List<String> getLocations(int id);
}
