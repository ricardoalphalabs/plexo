package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder(alphabetic=true)
public class CodeRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2199565723519780591L;
	public CodeAction action;
    public String code;
    public String issuerReferenceId;
    public BigDecimal returnAmount;

	public CodeRequest() {
		// TODO Auto-generated constructor stub
	}

	public CodeAction getAction() {
		return action;
	}

	public String getCode() {
		return code;
	}

	public void setAction(CodeAction action) {
		this.action = action;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIssuerReferenceId() {
		return issuerReferenceId;
	}

	public void setIssuerReferenceId(String issuerReferenceId) {
		this.issuerReferenceId = issuerReferenceId;
	}

	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}

	
}
