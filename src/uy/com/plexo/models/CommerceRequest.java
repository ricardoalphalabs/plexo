package uy.com.plexo.models;

import java.io.Serializable;

public class CommerceRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8821383047904341022L;

	public String name;
	public CommerceRequest() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
