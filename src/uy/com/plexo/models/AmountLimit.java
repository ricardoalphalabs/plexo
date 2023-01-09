package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmountLimit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7580589332479676837L;
    public BigDecimal amount;
    public BigDecimal extendedAmount;
    public Currency currency;
    public boolean supportsExtendedLimit;
	public AmountLimit() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getExtendedAmount() {
		return extendedAmount;
	}

	public void setExtendedAmount(BigDecimal extendedAmount) {
		this.extendedAmount = extendedAmount;
	}

	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public boolean isSupportsExtendedLimit() {
		return supportsExtendedLimit;
	}
	public void setSupportsExtendedLimit(boolean supportsExtendedLimit) {
		this.supportsExtendedLimit = supportsExtendedLimit;
	}

}
