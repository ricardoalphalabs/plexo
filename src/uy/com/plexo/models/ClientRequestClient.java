package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ClientRequestClient <T> extends SignedObjectGeneric<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8964198177395047926L;

	private String client;
	public ClientRequestClient() {
		// TODO Auto-generated constructor stub
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}

}
