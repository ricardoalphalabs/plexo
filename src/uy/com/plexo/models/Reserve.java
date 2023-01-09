package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class Reserve extends Reference implements Serializable {

	private static final long serialVersionUID = -3140308712551723595L;

	public Boolean commit;
	public BigDecimal finalAmount;
	public Reserve() {
		// TODO Auto-generated constructor stub
	}
	public Boolean getCommit() {
		return commit;
	}
	public void setCommit(Boolean commit) {
		this.commit = commit;
	}
	public BigDecimal getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}

}
