package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class Reference implements Serializable {

	private static final long serialVersionUID = -7617997306993255484L;
	
	public ReferenceType type;
    public String metaReference;
	public Reference() {
		// TODO Auto-generated constructor stub
	}
	public ReferenceType getType() {
		return type;
	}
	public void setType(ReferenceType type) {
		this.type = type;
	}
	public String getMetaReference() {
		return metaReference;
	}
	public void setMetaReference(String metaReference) {
		this.metaReference = metaReference;
	}

}
