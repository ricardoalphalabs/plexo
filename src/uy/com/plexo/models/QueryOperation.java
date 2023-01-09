package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
@JsonPropertyOrder(alphabetic=true)
public enum QueryOperation implements Serializable {
    And(0),
    Or(1),
    None(2);
	private int value;    

	private QueryOperation(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
