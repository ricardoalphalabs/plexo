package uy.com.plexo.models;

import java.io.Serializable;
import java.util.List;

public class IssuerInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6103188325120241068L;

	 public String id ;
     public int issuerId;
     public int variationId;
     public String issuer;
     public String bank;
     public String variation;
     public String imageUrl;
     public boolean mayHaveAsyncPayments;
     public boolean supportsReserve;
     public boolean mayHavePaymentsLimits;
     public List<FieldInfo> fields;
	public IssuerInfo() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIssuerId() {
		return issuerId;
	}
	public void setIssuerId(int issuerId) {
		this.issuerId = issuerId;
	}
	public int getVariationId() {
		return variationId;
	}
	public void setVariationId(int variationId) {
		this.variationId = variationId;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getVariation() {
		return variation;
	}
	public void setVariation(String variation) {
		this.variation = variation;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isMayHaveAsyncPayments() {
		return mayHaveAsyncPayments;
	}
	public void setMayHaveAsyncPayments(boolean mayHaveAsyncPayments) {
		this.mayHaveAsyncPayments = mayHaveAsyncPayments;
	}
	public boolean isSupportsReserve() {
		return supportsReserve;
	}
	public void setSupportsReserve(boolean supportsReserve) {
		this.supportsReserve = supportsReserve;
	}
	public boolean isMayHavePaymentsLimits() {
		return mayHavePaymentsLimits;
	}
	public void setMayHavePaymentsLimits(boolean mayHavePaymentsLimits) {
		this.mayHavePaymentsLimits = mayHavePaymentsLimits;
	}
	public List<FieldInfo> getFields() {
		return fields;
	}
	public void setFields(List<FieldInfo> fields) {
		this.fields = fields;
	}

}
