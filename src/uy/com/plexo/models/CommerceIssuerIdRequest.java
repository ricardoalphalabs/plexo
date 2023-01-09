package uy.com.plexo.models;

import java.io.Serializable;

public class CommerceIssuerIdRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -827806041886998038L;
    public Integer commerceId;
    public Integer issuerId;
    
	public CommerceIssuerIdRequest() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCommerceId() {
		return commerceId;
	}
	public Integer getIssuerId() {
		return issuerId;
	}
	public void setCommerceId(Integer commerceId) {
		this.commerceId = commerceId;
	}
	public void setIssuerId(Integer issuerId) {
		this.issuerId = issuerId;
	}
	
	

}
