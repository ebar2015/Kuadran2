package com.startapp.integraciones;

import java.io.Serializable;
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
import com.startapp.beans.woocommerce.WoocommerceCategory;


public class Woocommerce implements Serializable {

	private static final long serialVersionUID = -5667063789221502439L;
	/**
	 * 
	 */

	private static String username = "ck_7adb2d9c68cb0d74a4d85624c296bdca73a39fa4";
	private static String password = "cs_a1fc0e419ea5d209c1b0198d67498ef0f4b5500f";
	private static String authorization = "Basic Y2tfN2FkYjJkOWM2OGNiMGQ3NGE0ZDg1NjI0YzI5NmJkY2E3M2EzOWZhNDpjc19hMWZjMGU0MTllYTVkMjA5YzFiMDE5OGQ2NzQ5OGVmMGY0YjU1MDBm";
	private static String contentType = "application/json";
	private static String urlPath = "https://www.lapukids.com/";
	private static Gson gson = new Gson();

	public static List<WoocommerceCategory> getWoocommerceCategories() {
		List<WoocommerceCategory> wooCate = new ArrayList<WoocommerceCategory>();
		String restCall = urlPath + "wp-json/wc/v3/products/categories";

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
			Type listType = new TypeToken<List<WoocommerceCategory>>(){}.getType();
			wooCate = gson.fromJson(convertedObject.toString(), listType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return wooCate;
	}


}
