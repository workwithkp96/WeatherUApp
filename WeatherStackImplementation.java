package com.weatherapp.WeatherUapp.WeatherStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.boot.json.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.WeatherUapp.WeatherData.WeatherDataInformation;

public class WeatherStackImplementation implements WeatherStack{
	private String baseURL="https://api.weatherstack.com";
	
	@Override
	public WeatherDataInformation getCurrentWeatherData(String Location, String accessToken)
	{
		// TODO Auto-generated method stub
		String currentWeatherDataURL=baseURL+"/current?access_key="+accessToken+"&query="+Location;
		URL url=new URL(currentWeatherDataURL);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		if(con.getResponseCode()!=200)
			throw new RuntimeException(con.getResponseMessage());
		
		StringBuilder content;
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
            content=new StringBuilder();
            while((line=br.readLine())!=null) {

                content.append(line);
                content.append(System.lineSeparator());
            }
		}
		finally
		{
			con.disconnect();
		}
		
		ObjectMapper objectMapper =new ObjectMapper();
		WeatherDataInformation weatherdatainformation=objectMapper.readValue(content.toString(), WeatherDataInformation.class);
		
		return weatherdatainformation;
	}

	/*@Override
	public WeatherDataInformation getCurrentWeatherData(List<String> Locations, String accessToken) {
		// TODO Auto-generated method stub
		
		String currentWeatherDataURL=baseURL+"/current?access_key="+accessToken+"&query="+String.join(";",Locations);
		URL url=new URL(currentWeatherDataURL);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		if(con.getResponseCode()!=200)
			throw new RuntimeException(con.getResponseMessage());
		
		StringBuilder content;
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
            content=new StringBuilder();
            while((line=br.readLine())!=null) {

                content.append(line);
                content.append(System.lineSeparator());
            }
		}
		finally
		{
			con.disconnect();
		}
		
		ObjectMapper objectMapper =new ObjectMapper();
		WeatherDataInformation weatherdatainformation=objectMapper.readValue(content.toString(), WeatherDataInformation.class);
		
		return weatherdatainformation;
	}*/

	@Override
	public WeatherDataInformation getForcastForNextFiveDays(String Location, String accessToken) {
		// TODO Auto-generated method stub
		
		String ForcastWeatherDataURL=baseURL+"/current?access_key="+accessToken+"&query="+Location+"forecast_days=1&hourly=1";
		URL url=new URL(ForcastWeatherDataURL);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		if(con.getResponseCode()!=200)
			throw new RuntimeException(con.getResponseMessage());
		
		StringBuilder content;
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
            content=new StringBuilder();
            while((line=br.readLine())!=null) {

                content.append(line);
                content.append(System.lineSeparator());
            }
		}
		finally
		{
			con.disconnect();
		}
		
		ObjectMapper objectMapper =new ObjectMapper();
		WeatherDataInformation weatherdatainformation=objectMapper.readValue(content.toString(), WeatherDataInformation.class);
		
		return weatherdatainformation;
	}

	@Override
	public WeatherDataInformation getForcastForRequestedNextDays(String Location, int days, String accessToken) {
		// TODO Auto-generated method stub

		String ForcastWeatherDataURL=baseURL+"/current?access_key="+accessToken+"&query="+Location+"forecast_days="+days+"&hourly=1";
		URL url=new URL(ForcastWeatherDataURL);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		if(con.getResponseCode()!=200)
			throw new RuntimeException(con.getResponseMessage());
		
		StringBuilder content;
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
            content=new StringBuilder();
            while((line=br.readLine())!=null) {

                content.append(line);
                content.append(System.lineSeparator());
            }
		}
		finally
		{
			con.disconnect();
		}
		
		ObjectMapper objectMapper =new ObjectMapper();
		WeatherDataInformation weatherdatainformation=objectMapper.readValue(content.toString(), WeatherDataInformation.class);
		
		return weatherdatainformation;
	}

}
