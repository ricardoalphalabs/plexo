package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class PaymentRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6540762758248718425L;
	public String clientReferenceId;
	public PaymentInstrumentInput paymentInstrumentInput;
	public List<Item> items;
	public int currencyId;
    public int installments;
    public FinancialInclusion financialInclusion;
    public BigDecimal tipAmount;
    public Integer optionalCommerceId;
    public String optionalMetadata;
    public String optionalProvidedCode;
    public String optionalExternalPaymentInfo;
    public BigDecimal loyaltyProgramAmount;
	
	public PaymentRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getClientReferenceId() {
		return clientReferenceId;
	}

	public void setClientReferenceId(String clientReferenceId) {
		this.clientReferenceId = clientReferenceId;
	}

	public PaymentInstrumentInput getPaymentInstrumentInput() {
		return paymentInstrumentInput;
	}

	public void setPaymentInstrumentInput(PaymentInstrumentInput paymentInstrumentInput) {
		this.paymentInstrumentInput = paymentInstrumentInput;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public FinancialInclusion getFinancialInclusion() {
		return financialInclusion;
	}

	public void setFinancialInclusion(FinancialInclusion financialInclusion) {
		this.financialInclusion = financialInclusion;
	}

	public BigDecimal getTipAmount() {
		return tipAmount;
	}

	public void setTipAmount(BigDecimal tipAmount) {
		this.tipAmount = tipAmount;
	}


	public Integer getOptionalCommerceId() {
		return optionalCommerceId;
	}

	public void setOptionalCommerceId(Integer optionalCommerceId) {
		this.optionalCommerceId = optionalCommerceId;
	}

	public String getOptionalMetadata() {
		return optionalMetadata;
	}

	public void setOptionalMetadata(String optionalMetadata) {
		this.optionalMetadata = optionalMetadata;
	}

	public String getOptionalProvidedCode() {
		return optionalProvidedCode;
	}

	public void setOptionalProvidedCode(String optionalProvidedCode) {
		this.optionalProvidedCode = optionalProvidedCode;
	}

	public String getOptionalExternalPaymentInfo() {
		return optionalExternalPaymentInfo;
	}

	public void setOptionalExternalPaymentInfo(String optionalExternalPaymentInfo) {
		this.optionalExternalPaymentInfo = optionalExternalPaymentInfo;
	}

	public BigDecimal getLoyaltyProgramAmount() {
		return loyaltyProgramAmount;
	}

	public void setLoyaltyProgramAmount(BigDecimal loyaltyProgramAmount) {
		this.loyaltyProgramAmount = loyaltyProgramAmount;
	}

}
