package uy.com.plexo.models;

import java.io.Serializable;

public class CommerceIdRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5849103817876384334L;

	public Integer commerceId;
	public CommerceIdRequest() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCommerceId() {
		return commerceId;
	}
	public void setCommerceId(Integer commerceId) {
		this.commerceId = commerceId;
	}

}
