package com.weatherapp.WeatherUapp.WeatherData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataInformation {
	
	private Request request;
	private Location location;
	private Current current;
	private Forecast forcast;
	
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
	public Forecast getForcast() {
		return forcast;
	}
	public void setForcast(Forecast forcast) {
		this.forcast = forcast;
	}
}
