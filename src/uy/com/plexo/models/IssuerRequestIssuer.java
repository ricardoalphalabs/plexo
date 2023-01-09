package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class IssuerRequestIssuer <T> extends SignedObjectGeneric<T> implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -2287582702014666774L;
	private String issuer;
	public IssuerRequestIssuer() {
		// TODO Auto-generated constructor stub
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

}
