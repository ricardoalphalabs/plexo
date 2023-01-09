package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class FinancialInclusion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9144260636307715637L;
    public InclusionType type;
    public BigDecimal taxedAmount;
    public BigDecimal billedAmount;
    public int invoiceNumber;
    public String invoiceNumberStr;
    public BigDecimal vATAmount;
    //public BigDecimal pene;
	public FinancialInclusion() {
		// TODO Auto-generated constructor stub
	}
	public InclusionType getType() {
		return type;
	}
	public void setType(InclusionType type) {
		this.type = type;
	}
	public BigDecimal getTaxedAmount() {
		return taxedAmount;
	}
	public void setTaxedAmount(BigDecimal taxedAmount) {
		this.taxedAmount = taxedAmount;
	}
	public BigDecimal getBilledAmount() {
		return billedAmount;
	}
	public void setBilledAmount(BigDecimal billedAmount) {
		this.billedAmount = billedAmount;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceNumberStr() {
		return invoiceNumberStr;
	}
	public void setInvoiceNumberStr(String invoiceNumberStr) {
		this.invoiceNumberStr = invoiceNumberStr;
	}
	public BigDecimal getvATAmount() {
		return vATAmount;
	}
	public void setvATAmount(BigDecimal vATAmount) {
		this.vATAmount = vATAmount;
	}
	

}
