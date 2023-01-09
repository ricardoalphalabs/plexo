package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReferenceType implements Serializable {
	PlexoTransactionId(0),
	ClientPurchaseReferenceId(1),
	ClientCancelReferenceId(2),
	ClientReserveReferenceId(3);
	
	private int value;    

	private ReferenceType(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
