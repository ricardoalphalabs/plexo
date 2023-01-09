package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignedServerResponseGeneric <T> extends SignedObjectGeneric<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7267441028286233624L;

	public SignedServerResponseGeneric(){
		
	}
}
