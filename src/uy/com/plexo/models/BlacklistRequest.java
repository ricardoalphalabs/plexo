package uy.com.plexo.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement
@JsonPropertyOrder(alphabetic=true)
public class BlacklistRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String instrumentToken;
    private String reason;
    private String optionalUserName;
    
	public BlacklistRequest() {
		// TODO Auto-generated constructor stub
	}
	public String getInstrumentToken() {
		return instrumentToken;
	}
	public String getReason() {
		return reason;
	}
	public String getOptionalUserName() {
		return optionalUserName;
	}
	public void setInstrumentToken(String instrumentToken) {
		this.instrumentToken = instrumentToken;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setOptionalUserName(String optionalUserName) {
		this.optionalUserName = optionalUserName;
	}

}
