package com.startapp.integraciones;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.startapp.beans.rappi.RappiStore;

public class Rappi {
	
	
	private static String xauthorization = "bearer LFfpBJOA4OhoGhPPbDyzxY4a/XQA8KyK";
	private static String contentType = "application/json";
	// DEV private static String urlPath = "https://microservices.dev.rappi.com/api/v2/";
	private static String urlPath = "https://services.rappi.com/";
	
	// DEV private static String urlToken = "https://rests-integrations-dev.auth0.com/oauth/token";
	private static String urlToken = "https://rests-integrations.auth0.com/oauth/token";

		
	private static Gson gson = new Gson();
	
	
	public static String getRappiToken() {
		
		String token = null;
		
		HttpClient httpClient = HttpClient.newBuilder().build();
		
		String rappiCredentials = gson.toJson(new RappiCredentials());
			
		HttpRequest request = HttpRequest.newBuilder(URI.create(urlToken))
			      .header("Content-Type", contentType)
			      .POST(BodyPublishers.ofString(rappiCredentials))
			      .build();
		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, BodyHandlers.ofString());
			System.out.println("Response: " + response.body());
			token = response.body().toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return token;
	}
	
	public static List<RappiStore> getRappiStores() {
		List<RappiStore> rappiStores = new ArrayList<RappiStore>();
		String restCall = urlPath + "restaurants-integrations-public-api/stores";

		HttpClient httpClient = HttpClient.newBuilder().build();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(restCall))
				.headers("x-authorization", xauthorization, "Content-Type", contentType).build();
		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, BodyHandlers.ofString());
			System.out.println("Response: " + response.body());
			JsonObject convertedObject = new Gson().fromJson(response.body(), JsonObject.class);
			JsonArray convertedArray = convertedObject.get("items").getAsJsonArray();
			Type listType = new TypeToken<List<RappiStore>>(){}.getType();
			rappiStores = gson.fromJson(convertedArray.toString(), listType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rappiStores;
	}
	
}
