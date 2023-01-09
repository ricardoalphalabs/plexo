package uy.com.plexo.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AuthorizationType {
	ClientReference(0),
	OAuth(1),
	Anonymous(2);
	
	private int value;    

	private AuthorizationType(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
