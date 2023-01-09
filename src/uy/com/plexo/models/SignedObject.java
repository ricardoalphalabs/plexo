package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class SignedObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4792653562558616519L;
	private StateObject object;
    private String signature;
    
	public SignedObject() {
		// TODO Auto-generated constructor stub
	}

	public StateObject getObject() {
		return object;
	}

	public void setObject(StateObject object) {
		this.object = object;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
