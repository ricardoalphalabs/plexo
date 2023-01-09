package uy.com.plexo.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class PaymentInstrument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -937508478470602779L;
	public String instrumentToken;
    public String name;
    public IssuerInfo issuer;
    public List<Currency> supportedCurrencies;
    public CardStatus status;
    public long instrumentExpirationUTC;
    public int anonInstrumentUsageTimeLimit;
    public List<AmountLimit> creditLimits;
    public List<TimeLimit> additionalRequirements;
    public Map<FieldType,String> instrumentInformation;
    public String sessionCreationId;
	public PaymentInstrument() {
		// TODO Auto-generated constructor stub
	}
	public String getInstrumentToken() {
		return instrumentToken;
	}
	public void setInstrumentToken(String instrumentToken) {
		this.instrumentToken = instrumentToken;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IssuerInfo getIssuer() {
		return issuer;
	}
	public void setIssuer(IssuerInfo issuer) {
		this.issuer = issuer;
	}
	public List<Currency> getSupportedCurrencies() {
		return supportedCurrencies;
	}
	public void setSupportedCurrencies(List<Currency> supportedCurrencies) {
		this.supportedCurrencies = supportedCurrencies;
	}
	public CardStatus getStatus() {
		return status;
	}
	public void setStatus(CardStatus status) {
		this.status = status;
	}
	public long getInstrumentExpirationUTC() {
		return instrumentExpirationUTC;
	}
	public void setInstrumentExpirationUTC(long instrumentExpirationUTC) {
		this.instrumentExpirationUTC = instrumentExpirationUTC;
	}
	public int getAnonInstrumentUsageTimeLimit() {
		return anonInstrumentUsageTimeLimit;
	}
	public void setAnonInstrumentUsageTimeLimit(int anonInstrumentUsageTimeLimit) {
		this.anonInstrumentUsageTimeLimit = anonInstrumentUsageTimeLimit;
	}
	public List<AmountLimit> getCreditLimits() {
		return creditLimits;
	}
	public void setCreditLimits(List<AmountLimit> creditLimits) {
		this.creditLimits = creditLimits;
	}
	public List<TimeLimit> getAdditionalRequirements() {
		return additionalRequirements;
	}
	public void setAdditionalRequirements(List<TimeLimit> additionalRequirements) {
		this.additionalRequirements = additionalRequirements;
	}
	public Map<FieldType, String> getInstrumentInformation() {
		return instrumentInformation;
	}
	public void setInstrumentInformation(Map<FieldType, String> instrumentInformation) {
		this.instrumentInformation = instrumentInformation;
	}
	public String getSessionCreationId() {
		return sessionCreationId;
	}
	public void setSessionCreationId(String sessionCreationId) {
		this.sessionCreationId = sessionCreationId;
	}

}
