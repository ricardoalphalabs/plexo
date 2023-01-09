package uy.com.plexo.models;

import java.io.Serializable;

public class PublicKeyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1044811391700411764L;
	private String fingerprint;
	private String key;
	public PublicKeyInfo() {
		// TODO Auto-generated constructor stub
	}
	public String getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

}
