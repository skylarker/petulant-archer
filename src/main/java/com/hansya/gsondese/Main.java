package com.hansya.gsondese;

public class Main {

	public static void main(String... args) {
		Location location = new Location("Bangalore, KN, India");
		location.parseLocationString();
		System.out.println(location);
		String json = location.convertToJSON(location);
		System.out.println(json);
	}

}
