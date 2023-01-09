package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class SignedObjectGeneric <T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7458583488776016473L;
	private StateObjectGeneric<T> object;
    private String signature;
	public SignedObjectGeneric() {
		// TODO Auto-generated constructor stub
	}

	public StateObjectGeneric<T> getObject() {
		return object;
	}
	public void setObject(StateObjectGeneric<T> object) {
		this.object = object;
	}

	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}

}

