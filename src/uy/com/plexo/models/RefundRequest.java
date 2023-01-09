package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement
@JsonPropertyOrder(alphabetic=true)
public class RefundRequest extends Reference implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1674303099236885884L;
	public String clientReferenceId;
	public BigDecimal amount;
	public int optionalClientId;

	public RefundRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getClientReferenceId() {
		return clientReferenceId;
	}

	public void setClientReferenceId(String clientReferenceId) {
		this.clientReferenceId = clientReferenceId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public int getOptionalClientId() {
		return optionalClientId;
	}

	public void setOptionalClientId(int optionalClientId) {
		this.optionalClientId = optionalClientId;
	}

}
