package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
@JsonPropertyOrder(alphabetic=true)
public enum TransactionOperator implements Serializable {
    Equal(0),
    NotEqual(1),
    BiggerThan(2),
    BiggerOrEqualThan(3),
    SmallerThan(4),
    SmallerOrEqualThen(5),
    Contains(6),
    NotContains(7);
	
	private int value;    

	private TransactionOperator(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
