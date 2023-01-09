package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ClientSignedRequest extends SignedObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3730169101976616395L;

	public ClientSignedRequest() {
		// TODO Auto-generated constructor stub
	}

}
