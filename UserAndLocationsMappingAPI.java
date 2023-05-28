package com.weatherapp.WeatherUapp.RESTAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapp.WeatherUapp.Entity.UserAndLocationsMapping;
import com.weatherapp.WeatherUapp.Service.UserAndLocationsMappingService;

@RestController
@RequestMapping("/api")
public class UserAndLocationsMappingAPI {
	
	private UserAndLocationsMappingService userandlocationsmappingservice;
	
	@Autowired
	public UserAndLocationsMappingAPI(UserAndLocationsMappingService userandlocationsmappingservice) {
		super();
		this.userandlocationsmappingservice = userandlocationsmappingservice;
	}
	
	@PostMapping("/locations/{user_id}")
	public String saveLocations(@PathVariable int user_id, @RequestBody List<String> locations)
	{
		UserAndLocationsMapping userandlocationmapping=new UserAndLocationsMapping(user_id, locations);
		userandlocationsmappingservice.saveLocations(userandlocationmapping);
		return "Thank you choosing you locations. Now sit back and stay updated !";
	}
	
	@DeleteMapping("/locations/{user_id}")
	public String deleteLocation(@PathVariable int user_id)
	{
		try
		{
			userandlocationsmappingservice.deleteLocations(user_id);
		}
		catch (RuntimeException e)
		{
			return "UserID " + user_id + " does not exist";
		}
		
		return "Locations for UseID " + user_id + " deleted";
	}
}
