package uy.com.plexo.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement
@JsonPropertyOrder(alphabetic=true)
public class CancelRequest extends Reference implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8597610300782131418L;
	public String clientReferenceId;
	public int optionalClientId;

	public CancelRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getClientReferenceId() {
		return clientReferenceId;
	}

	public void setClientReferenceId(String clientReferenceId) {
		this.clientReferenceId = clientReferenceId;
	}

	public int getOptionalClientId() {
		return optionalClientId;
	}

	public void setOptionalClientId(int optionalClientId) {
		this.optionalClientId = optionalClientId;
	}

}
