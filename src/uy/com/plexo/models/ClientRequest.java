package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ClientRequest <T> extends ClientRequestClient<T> implements Serializable {

	private static final long serialVersionUID = -2659436183035519494L;
	
	public ClientRequest(){}
	
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
	


	


