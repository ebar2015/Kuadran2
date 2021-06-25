package com.startapp.integraciones;

public class RappiCredentials {
	
	private static String client_id = "7iCfjZCO4bTns3OjqLK4de2GV3sp6Ymd";
	private static String client_secret = "40iFFYJV9A1LrVmJsaIeARW40iFFYJV9A1LrVmJsaIeARW40iFFYJV9A1LrVmJsaIeARW";
	private static String audience  = "https://int-public-api-v2/api";
	private static String grant_type = "client_credentials";
	
	
	public static String getClient_id() {
		return client_id;
	}
	public static void setClient_id(String client_id) {
		RappiCredentials.client_id = client_id;
	}
	public static String getClient_secret() {
		return client_secret;
	}
	public static void setClient_secret(String client_secret) {
		RappiCredentials.client_secret = client_secret;
	}
	public static String getAudience() {
		return audience;
	}
	public static void setAudience(String audience) {
		RappiCredentials.audience = audience;
	}
	public static String getGrant_type() {
		return grant_type;
	}
	public static void setGrant_type(String grant_type) {
		RappiCredentials.grant_type = grant_type;
	}
	
	

}
