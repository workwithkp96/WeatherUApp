package com.weatherapp.WeatherUapp.WeatherData;

import java.util.List;

public class Forecast {

	private String date;
	private Astro astro;
	private int mintemp;
	private int maxtemp;
	private int avgtemp;
	private int totalsnow;
	private int sunhour;
	private int uv_index;
	private List<Hourly> hourly;
	
	//generating getters and setters....
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Astro getAstro() {
		return astro;
	}
	public void setAstro(Astro astro) {
		this.astro = astro;
	}
	public int getMintemp() {
		return mintemp;
	}
	public void setMintemp(int mintemp) {
		this.mintemp = mintemp;
	}
	public int getMaxtemp() {
		return maxtemp;
	}
	public void setMaxtemp(int maxtemp) {
		this.maxtemp = maxtemp;
	}
	public int getAvgtemp() {
		return avgtemp;
	}
	public void setAvgtemp(int avgtemp) {
		this.avgtemp = avgtemp;
	}
	public int getTotalsnow() {
		return totalsnow;
	}
	public void setTotalsnow(int totalsnow) {
		this.totalsnow = totalsnow;
	}
	public int getSunhour() {
		return sunhour;
	}
	public void setSunhour(int sunhour) {
		this.sunhour = sunhour;
	}
	public int getUv_index() {
		return uv_index;
	}
	public void setUv_index(int uv_index) {
		this.uv_index = uv_index;
	}
	public List<Hourly> getHourly() {
		return hourly;
	}
	public void setHourly(List<Hourly> hourly) {
		this.hourly = hourly;
	}
}
