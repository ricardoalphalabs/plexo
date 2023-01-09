package uy.com.plexo.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {
	SelectInstrument(1),
	RegisterInstrument(2),
	SelectAndRegisterInstrument(3),
	DeleteInstrument(4),
	SessionExtendAmount(8),
	ClientExtendAmount(16),
	AskForTemporaryItems(32),
	ExpressCheckout(64),
	SelectItWithTemporaryItems(33),
	RegisterInstrumentWithTemporaryItems(34),
	SelectAndRegisterInstrumentWithTemporaryItems(35),
	DeleteAndRegister(6),
	SelectDeleteAndRegisterInstrument(7),
	SelectDeleteAndRegisterInstrumentWithTemporaryItems(39);
	
	private int value;    

	private ActionType(int value) {
	    this.value = value;
	}

	@JsonValue
	public int getValue() {
	    return value;
	}
}
