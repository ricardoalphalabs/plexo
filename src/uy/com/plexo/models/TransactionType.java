package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType implements Serializable {
	Reserve(0),
    Purchase(1),
    Cancel(2),
	Refund(3);
    
    private int value;    

	private TransactionType(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
