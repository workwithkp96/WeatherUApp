package com.weatherapp.WeatherUapp.WeatherStack;

import java.io.IOException;
import java.util.List;
import com.weatherapp.WeatherUapp.WeatherData.WeatherDataInformation;


public interface WeatherStack {
	public WeatherDataInformation getCurrentWeatherData(String Location, String accessToken) throws IOException;
	//public WeatherDataInformation getCurrentWeatherData(List<String> Locations, String accessToken);
	public WeatherDataInformation getForcastForNextFiveDays(String Location,String accessToken);
	public WeatherDataInformation getForcastForRequestedNextDays(String Location,int days, String accessToken);
}
