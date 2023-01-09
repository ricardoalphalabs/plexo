package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
@JsonPropertyOrder(alphabetic=true)
public enum TransactionOrderDirection implements Serializable {

    Asc(0),
    Desc(1);
	
	private int value;    

	private TransactionOrderDirection(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
