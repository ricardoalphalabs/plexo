package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class CommerceModifyRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3172332225055146338L;
	private Integer commerceId;
	private String name;
	public CommerceModifyRequest() {
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
