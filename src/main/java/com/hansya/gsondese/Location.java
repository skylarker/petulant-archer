package com.hansya.gsondese;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class Location {

	private String location;

	@Expose
	private String city;

	@Expose
	private String state;

	@Expose
	private String country;

	private Gson gson;

	public Location(String location) {
		this.location = location;
		// gson = new Gson();
		// gson = new GsonBuilder().setPrettyPrinting().create();
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		// .create();

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

	protected void writeJson(String jsonString) {
		try {
			FileWriter fileWriter = new FileWriter("out.json");
			fileWriter.write(jsonString);
			fileWriter.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
