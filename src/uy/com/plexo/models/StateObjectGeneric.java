package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class StateObjectGeneric <T> extends StateObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1144435249000436238L;
	private T object;
	public StateObjectGeneric() {
		// TODO Auto-generated constructor stub
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}

}
