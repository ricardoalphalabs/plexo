package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ReserveRequest extends PaymentRequest implements Serializable {


	private static final long serialVersionUID = 7817411442615317725L;
	public long expirationUTC;

	public ReserveRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public long getExpirationUTC() {
		return expirationUTC;
	}
	public void setExpirationUTC(long expirationUTC) {
		this.expirationUTC = expirationUTC;
	}


}
