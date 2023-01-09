package uy.com.plexo.models;

import java.io.Serializable;

public class Commerce implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5062071350135069879L;
    public Integer commerceId;
    public String name;
	public Commerce() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCommerceId() {
		return commerceId;
	}
	public String getName() {
		return name;
	}
	public void setCommerceId(Integer commerceId) {
		this.commerceId = commerceId;
	}
	public void setName(String name) {
		this.name = name;
	}

}
