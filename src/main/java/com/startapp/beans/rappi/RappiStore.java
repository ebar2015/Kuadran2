package com.startapp.beans.rappi;

public class RappiStore {

	private String integrationId;
	private String rappiId;
	private String name;

	public String getIntegrationId() {
		return integrationId;
	}

	public void setIntegrationId(String integrationId) {
		this.integrationId = integrationId;
	}

	public String getRappiId() {
		return rappiId;
	}

	public void setRappiId(String rappiId) {
		this.rappiId = rappiId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RappiStore [integrationId=" + integrationId + ", rappiId=" + rappiId + ", name=" + name + "]";
	}

	
}