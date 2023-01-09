package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ExpressCheckoutRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3518196443865479393L;
	public Authorization authorizationData;
	public PaymentRequest paymentData;
	public ExpressCheckoutRequest() {
		// TODO Auto-generated constructor stub
	}
	public Authorization getAuthorizationData() {
		return authorizationData;
	}
	public PaymentRequest getPaymentData() {
		return paymentData;
	}
	public void setAuthorizationData(Authorization authorizationData) {
		this.authorizationData = authorizationData;
	}
	public void setPaymentData(PaymentRequest paymentData) {
		this.paymentData = paymentData;
	}

}
