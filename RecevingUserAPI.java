package com.weatherapp.WeatherUapp.RESTAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapp.WeatherUapp.Service.UserAccountDetailsService;
import com.weatherapp.WeatherUapp.Service.UserAndLocationsMappingService;
import com.weatherapp.WeatherUapp.WeatherData.WeatherDataInformation;
import com.weatherapp.WeatherUapp.WeatherStack.WeatherStackImplementation;

@RestController
@RequestMapping("/api")
public class RecevingUserAPI {
	
	private WeatherStackImplementation weatherstackdata;
	private UserAccountDetailsService useraccountservice;
	private UserAndLocationsMappingService userandlocationmappingservice;
	
	@Autowired
	public RecevingUserAPI(WeatherStackImplementation weatherstackdata,UserAccountDetailsService useraccountservice,UserAndLocationsMappingService userandlocationmappingservice) {
		super();
		this.weatherstackdata = weatherstackdata;
		this.useraccountservice=useraccountservice;
		this.userandlocationmappingservice=userandlocationmappingservice;
	}
	
	@GetMapping("/api/current/{user_id}/{location}")
	public WeatherDataInformation getCurrentWeatherData(@PathVariable int user_id, @PathVariable String location)
	{
		String accessToken=useraccountservice.getAccessToken(user_id);
		WeatherDataInformation weatherdata=weatherstackdata.getCurrentWeatherData(location, accessToken);
		return weatherdata;
	}
	
	@GetMapping("/api/forcast/{user_id}/{location}")
	public WeatherDataInformation getWeatherForcastData(@PathVariable int user_id,@PathVariable String location)
	{
		String accessToken=useraccountservice.getAccessToken(user_id);
		WeatherDataInformation weatherdata=weatherstackdata.getForcastForNextFiveDays(location, accessToken);
		return weatherdata;
	}
	
	@GetMapping("/api/current/{user_id}/locations")
	public List<WeatherDataInformation> getCurrentWeatherData(@PathVariable int user_id)
	{
		String accessToken=useraccountservice.getAccessToken(user_id);
		List <String> Locations=userandlocationmappingservice.getLocations(user_id);
		List <WeatherDataInformation> weatherdataforlocations=new ArrayList<>();
		for(String location : Locations)
		{
			WeatherDataInformation weatherdata=weatherstackdata.getCurrentWeatherData(location, accessToken);
			weatherdataforlocations.add(weatherdata);
		}
		return weatherdataforlocations;
	}
	
	@GetMapping("/api/forcast/{user_id}/{location}/")
	public WeatherDataInformation getForcastForRequestedNextDays(@PathVariable int user_id,@RequestParam("day") int day,@PathVariable String location)
	{
		String accessToken=useraccountservice.getAccessToken(user_id);
		WeatherDataInformation weatherdata=weatherstackdata.getForcastForRequestedNextDays(location, day, accessToken);
		return weatherdata;
	}
	
}
