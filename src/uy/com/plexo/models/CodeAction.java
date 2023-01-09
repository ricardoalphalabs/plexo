package uy.com.plexo.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CodeAction {
    Query(0),
    Pay(1),
    Deny(2),
    EndCancelation(3),
    Void(4);
	
	private int value;    

	private CodeAction(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}

}
