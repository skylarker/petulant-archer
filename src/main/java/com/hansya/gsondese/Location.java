package com.hansya.gsondese;

import com.google.gson.Gson;

public class Location {

	private String location;

	private String city;

	private String state;

	private String country;

	private Gson gson;

	public Location(String location) {
		this.location = location;
		gson = new Gson();
	}

	protected String getLocation() {
		return location;
	}

	protected void setLocation(String location) {
		this.location = location;
	}

	protected String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	protected String getState() {
		return state;
	}

	protected void setState(String state) {
		this.state = state;
	}

	protected String getCountry() {
		return country;
	}

	protected void setCountry(String country) {
		this.country = country;
	}

	protected void parseLocationString() {
		String[] tokens = location.split("\\s*,\\s*");
		setCity(tokens[0]);
		setState(tokens[1]);
		setCountry(tokens[2]);
	}

	@Override
	public String toString() {
		return "Location: [" + getCity() + "," + getState() + ","
				+ getCountry() + "]";
	}

	protected String convertToJSON(Location location) {
		return gson.toJson(location);
	}
}
