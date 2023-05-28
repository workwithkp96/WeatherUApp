package com.weatherapp.WeatherUapp.Entity;

import java.util.List;

public interface UserAndLocationMappingDAO {
	public void saveLocations(UserAndLocationsMapping userandlocationmapping);
	public void deleteLocations(int id);
	public List<String> getLocations(int id);
}
