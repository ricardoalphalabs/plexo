package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ClientSignedRequestGeneric <T> extends SignedObjectGeneric<T> implements Serializable {

	private static final long serialVersionUID = 5886922828401257388L;

	public ClientSignedRequestGeneric() {
		// TODO Auto-generated constructor stub
	}

}
