package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class IssuerRequest <T> extends IssuerRequestIssuer<T> implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4189426329145648535L;
	public IssuerRequest(){}
	
	private T request;
	public final T getRequest()
	{
		return request;
	}
	public final void setRequest(T value)
	{
		request = value;
	}
}
	


	


