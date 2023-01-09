package uy.com.plexo.models;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class DeleteInstrumentRequest extends AuthorizationInfo implements Serializable {
	private static final long serialVersionUID = -6963000787657189214L;
	public String instrumentToken;

	public DeleteInstrumentRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getInstrumentToken() {
		return instrumentToken;
	}

	public void setInstrumentToken(String instrumentToken) {
		this.instrumentToken = instrumentToken;
	}

}
