package com.weatherapp.WeatherUapp.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class UserAndLocationsMappingImplementation implements UserAndLocationMappingDAO{

	private EntityManager entityManager;
	
	@Autowired
	public UserAndLocationsMappingImplementation(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void saveLocations(UserAndLocationsMapping userandlocationmapping) {
		// TODO Auto-generated method stub
		entityManager.persist(userandlocationmapping);
	}

	@Override
	public void deleteLocations(int id) {
		// TODO Auto-generated method stub
		UserAndLocationsMapping userandlocationsmapping=entityManager.find(UserAndLocationsMapping.class,id);
		entityManager.remove(userandlocationsmapping);
	}

	@Override
	public List<String> getLocations(int id) {
		// TODO Auto-generated method stub
		
		UserAndLocationsMapping userandlocationsmapping=entityManager.find(UserAndLocationsMapping.class,id);
		List<String> Locations = userandlocationsmapping.getLocations();
		return Locations;
	}

}
