package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InclusionType implements Serializable {
	None(0),
	Law17934(1),
	Law19210(6);
	
	private int value;    

	private InclusionType(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
