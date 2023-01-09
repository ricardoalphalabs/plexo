package uy.com.plexo.models;

import java.io.Serializable;
import java.util.Map;

public class IssuerData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8779278534277533889L;

    public Integer issuerId;
    public Integer commerceId;
    public Map<FieldType,String> metadata;
    
	public IssuerData() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIssuerId() {
		return issuerId;
	}

	public Integer getCommerceId() {
		return commerceId;
	}

	public Map<FieldType, String> getMetadata() {
		return metadata;
	}

	public void setIssuerId(Integer issuerId) {
		this.issuerId = issuerId;
	}

	public void setCommerceId(Integer commerceId) {
		this.commerceId = commerceId;
	}

	public void setMetadata(Map<FieldType, String> metadata) {
		this.metadata = metadata;
	}

}
