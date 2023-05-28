package com.weatherapp.WeatherUapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.weatherapp.WeatherUapp.Entity.UserAndLocationMappingDAO;
import com.weatherapp.WeatherUapp.Entity.UserAndLocationsMapping;

import jakarta.transaction.Transactional;

public class UserAndLocationsMappingServiceImplementation implements UserAndLocationsMappingService{
	
	private UserAndLocationMappingDAO userandlocationmappingdao;
	
	@Autowired
	public UserAndLocationsMappingServiceImplementation(UserAndLocationMappingDAO userandlocationmappingdao) {
		super();
		this.userandlocationmappingdao = userandlocationmappingdao;
	}

	@Override
	@Transactional
	public void saveLocations(UserAndLocationsMapping userandlocationsmapping) {
		// TODO Auto-generated method stub
		userandlocationmappingdao.saveLocations(userandlocationsmapping);
	}

	@Override
	@Transactional
	public void deleteLocations(int id) {
		// TODO Auto-generated method stub
		userandlocationmappingdao.deleteLocations(id);
	}

	@Override
	public List<String> getLocations(int id) {
		// TODO Auto-generated method stub
		List <String> Locations=userandlocationmappingdao.getLocations(id); 
		return Locations;
	}
	

}
