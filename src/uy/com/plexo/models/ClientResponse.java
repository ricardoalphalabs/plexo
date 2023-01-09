package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ClientResponse<T> extends ServerResponseGeneric<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1935753952410957921L;
	private String client;
	
	public ClientResponse(){}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
