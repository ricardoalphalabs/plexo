package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class StateObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6264183190995081651L;
	private String fingerprint;
    private long UTCUnixTimeExpiration;
	public StateObject() {
		// TODO Auto-generated constructor stub
	}
	public String getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	@JsonProperty("UTCUnixTimeExpiration")
	public long getUTCUnixTimeExpiration() {
		return UTCUnixTimeExpiration;
	}
	public void setUTCUnixTimeExpiration(long UTCUnixTimeExpiration) {
		this.UTCUnixTimeExpiration = UTCUnixTimeExpiration;
	}

}
