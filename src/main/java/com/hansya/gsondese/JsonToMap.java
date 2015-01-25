package com.hansya.gsondese;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonToMap {

	private Gson gson;

	private Type jsonMapType;

	public JsonToMap() {
		gson = new Gson();
		jsonMapType = new TypeToken<Map<String, String>>() {
		}.getType();

	}

	protected void readJsonFile() {
		try {
			FileReader fileReader = new FileReader("out.json");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String jsonString;
			while ((jsonString = bufferedReader.readLine()) != null) {
				convertJsonToMap(jsonString);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void convertJsonToMap(String jsonString) {
		System.out.println(gson.fromJson(jsonString, jsonMapType));
	}
}
