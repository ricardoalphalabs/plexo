package uy.com.plexo.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResultCodes {
	Ok(0),												//0 
	ArgumentError(1),									//1 
	InvalidSession(2),									//2 
	SessionExpired(3),									//3 
	TokenExpired(4),									//4 
	MissingPaymentInstrument(5),						//5 
	DuplicateTransaction(6),							//6 
	SystemError(7),									//7 
	ClientServerError(8),								//8 
	DisabledCard(9),									//9 
	ExpiredCard(10),									//10 
	NotFound(11),										//11 
	InvalidFingerprint(12),							//12 
	InvalidSignature(13),								//13 
	MessageExpired(14),									//14 
	InvalidPaymentInstrument(15),						//15 
	CurrencyNotSupportedByInstrument(16),				//16 
	IssuerNotAssociatedWithClientOrIssuerInactive(17),	//17 
	InvalidCurrency(18),								//18 
	InvalidCard(19),									//19 
	ExternalLimitedCard(20),							//20 
	Forbidden(21),										//21 
	InvalidVerification(22),							//22 
	RequiresSessionExtendedAmount(23),					//23 
	RequiresClientExtendedAmount(24),					//24
    AlreadyExists(25),									//25	
    MissingFields(26),									//26
    CodeExpired(27);									//27
	
	private int value;    

	private ResultCodes(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
