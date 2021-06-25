package com.startapp.integraciones;

import java.lang.reflect.Type;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.startapp.beans.alegra.AlegraWarehouse;
import com.startapp.beans.alegra.AlegraCategory;

public class Alegra {
	
	private static String username = "somos@lapukids.com";
	private static String password = "1e14c761b693e91d6464";
	private static String authorization = "Basic c29tb3NAbGFwdWtpZHMuY29tOjFlMTRjNzYxYjY5M2U5MWQ2NDY0";
	private static String contentType = "application/json";
	private static String urlPath = "https://api.alegra.com/api/v1/";
	private static Gson gson = new Gson();
	
	public static List<AlegraCategory> getAlegraCategories() {
		List<AlegraCategory> alegraCats = new ArrayList<AlegraCategory>();
		String restCall = urlPath + "item-categories";

		HttpClient httpClient = HttpClient.newBuilder().authenticator(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password.toCharArray());
			}

		}).build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(restCall))
				.headers("Authorization", authorization, "Content-Type", contentType).build();
		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, BodyHandlers.ofString());
			JsonArray convertedObject = new Gson().fromJson(response.body(), JsonArray.class);
			Type listType = new TypeToken<List<AlegraCategory>>(){}.getType();
			alegraCats = gson.fromJson(convertedObject.toString(), listType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alegraCats;
	}
	public static List<AlegraWarehouse> getAlegraAlmacenes() {
		List<AlegraWarehouse> alegraAlma = new ArrayList<AlegraWarehouse>();
		String restCall = urlPath + "warehouses";

		HttpClient httpClient = HttpClient.newBuilder().authenticator(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password.toCharArray());
			}

		}).build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(restCall))
				.headers("Authorization", authorization, "Content-Type", contentType).build();
		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, BodyHandlers.ofString());
			JsonArray convertedObject = new Gson().fromJson(response.body(), JsonArray.class);
			Type listType = new TypeToken<List<AlegraWarehouse>>(){}.getType();
			alegraAlma = gson.fromJson(convertedObject.toString(), listType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alegraAlma;
	}
}
