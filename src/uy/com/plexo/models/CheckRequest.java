package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class CheckRequest implements Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 141042612191171541L;
	public String instrumentToken;
	public String cardType;
    public String cvNumber;
    public Integer optionalCommerceId;
    public String clientReferenceId;
    public int currencyId;
    public BigDecimal amount;
    public String redirectUri;
    
	public String getInstrumentToken() {
		return instrumentToken;
	}
	public void setInstrumentToken(String instrumentToken) {
		this.instrumentToken = instrumentToken;
	}
	public CheckRequest() {
		// TODO Auto-generated constructor stub
	}
	public String getCardType() {
		return cardType;
	}
	public String getCvNumber() {
		return cvNumber;
	}
	public Integer getOptionalCommerceId() {
		return optionalCommerceId;
	}
	public String getClientReferenceId() {
		return clientReferenceId;
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public void setCvNumber(String cvNumber) {
		this.cvNumber = cvNumber;
	}
	public void setOptionalCommerceId(Integer optionalCommerceId) {
		this.optionalCommerceId = optionalCommerceId;
	}
	public void setClientReferenceId(String clientReferenceId) {
		this.clientReferenceId = clientReferenceId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	

}
