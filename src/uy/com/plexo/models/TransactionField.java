package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
@JsonPropertyOrder(alphabetic=true)
public enum TransactionField implements Serializable {
    CreationDate(0),
    TransactionState(1),
    PurchaseStatus(2),
    CancelStatus(3),
    ReserveStatus(4),
    TransactionId(5),
    IssuerId(6),
    BankId(7),
    CommerceId(8),
    PurchaseExternalId(9),
    CancelExternalId(10),
    ReserveExternalId(11),      
    PurchaseAuthorization(12),
    CancelAuthorization(13),
    ReserveAuthorization(14),
    PurchaseMetadata(15),
    CancelMetadata(16),
    ReserveMetadata(17),
    Metadata(18);
	
	private int value;    

	private TransactionField(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
