package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ClientSignedResponse <T> extends SignedObjectGeneric<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2706962061881800457L;

	public ClientSignedResponse() {
		// TODO Auto-generated constructor stub
	}

}
