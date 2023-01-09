package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinancialInclusionResult implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8596193169961097745L;
	public Boolean isApplied;
    public BigDecimal returnAmount;
    public InclusionType lawNumber;
	public FinancialInclusionResult() {
		// TODO Auto-generated constructor stub
	}
	public Boolean getIsApplied() {
		return isApplied;
	}
	public BigDecimal getReturnAmount() {
		return returnAmount;
	}
	public InclusionType getLawNumber() {
		return lawNumber;
	}
	public void setIsApplied(Boolean isApplied) {
		this.isApplied = isApplied;
	}
	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}
	public void setLawNumber(InclusionType lawNumber) {
		this.lawNumber = lawNumber;
	}

}
