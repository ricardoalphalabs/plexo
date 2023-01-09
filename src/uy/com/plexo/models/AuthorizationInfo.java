package uy.com.plexo.models;

import java.io.Serializable;

public class AuthorizationInfo implements Serializable {

	private static final long serialVersionUID = 7527017828543976491L;

    public AuthorizationType type;
    public String metaReference;
    
	public AuthorizationInfo() {
		// TODO Auto-generated constructor stub
	}

	public AuthorizationType getType() {
		return type;
	}

	public void setType(AuthorizationType type) {
		this.type = type;
	}

	public String getMetaReference() {
		return metaReference;
	}

	public void setMetaReference(String metaReference) {
		this.metaReference = metaReference;
	}

}
