package com.weatherapp.WeatherUapp.WeatherData;

import java.util.List;

public class Current {
	private String observation_time;
	private int temperature;
	private int weather_code;
	private List<String> weather_icon;
	private List<String> weather_descriptions;
	private int wind_speed;
	private double wind_degree;
	private String wind_dir;
	private int pressure;
	private int humidity;
	private int cloudcover;
	private int uvindex;
	private int visibility;
	
	public String getObservation_time() {
		return observation_time;
	}
	public void setObservation_time(String observation_time) {
		this.observation_time = observation_time;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getWeather_code() {
		return weather_code;
	}
	public void setWeather_code(int weather_code) {
		this.weather_code = weather_code;
	}
	public List<String> getWeather_icon() {
		return weather_icon;
	}
	public void setWeather_icon(List<String> weather_icon) {
		this.weather_icon = weather_icon;
	}
	public List<String> getWeather_descriptions() {
		return weather_descriptions;
	}
	public void setWeather_descriptions(List<String> weather_descriptions) {
		this.weather_descriptions = weather_descriptions;
	}
	public int getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(int wind_speed) {
		this.wind_speed = wind_speed;
	}
	public double getWind_degree() {
		return wind_degree;
	}
	public void setWind_degree(double wind_degree) {
		this.wind_degree = wind_degree;
	}
	public String getWind_dir() {
		return wind_dir;
	}
	public void setWind_dir(String wind_dir) {
		this.wind_dir = wind_dir;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getCloudcover() {
		return cloudcover;
	}
	public void setCloudcover(int cloudcover) {
		this.cloudcover = cloudcover;
	}
	public int getUvindex() {
		return uvindex;
	}
	public void setUvindex(int uvindex) {
		this.uvindex = uvindex;
	}
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	
	
}
