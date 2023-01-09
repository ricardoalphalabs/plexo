package uy.com.plexo.models;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class PaymentInstrumentInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4988304769672390268L;
    public String instrumentToken;
    public Map<FieldType,String> nonStorableItems;
    public boolean useExtendedClientCreditIfAvailable;
    public Map<FieldType,String> optionalInstrumentFields;
	public PaymentInstrumentInput() {
		// TODO Auto-generated constructor stub
	}
	public String getInstrumentToken() {
		return instrumentToken;
	}
	public void setInstrumentToken(String instrumentToken) {
		this.instrumentToken = instrumentToken;
	}
	public Map<FieldType, String> getNonStorableItems() {
		return nonStorableItems;
	}
	public void setNonStorableItems(Map<FieldType, String> nonStorableItems) {
		this.nonStorableItems = nonStorableItems;
	}
	public boolean isUseExtendedClientCreditIfAvailable() {
		return useExtendedClientCreditIfAvailable;
	}
	public void setUseExtendedClientCreditIfAvailable(boolean useExtendedClientCreditIfAvailable) {
		this.useExtendedClientCreditIfAvailable = useExtendedClientCreditIfAvailable;
	}
	public Map<FieldType, String> getOptionalInstrumentFields() {
		return optionalInstrumentFields;
	}
	public void setOptionalInstrumentFields(Map<FieldType, String> optionalInstrumentFields) {
		this.optionalInstrumentFields = optionalInstrumentFields;
	}

}
