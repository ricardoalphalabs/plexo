package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1530298061136691774L;
    public String TransactionId;
    public Commerce Commerce;
    public String InstrumentToken;
    public String InstrumentName;
    public IssuerInfo Issuer;
    public BigDecimal Amount;
    public Integer Installments;
    public Currency Currency;
    public Boolean IsAnonymous;
    public TransactionType CurrentState;
    public String InvoiceNumber;
    public FinancialInclusionResult FinancialInclusion;
    public HashMap<TransactionType, TransactionInfo> Transactions;
    public HashMap<FieldType, String> FieldInformation;
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public String getTransactionId() {
		return TransactionId;
	}
	public Commerce getCommerce() {
		return Commerce;
	}
	public String getInstrumentToken() {
		return InstrumentToken;
	}
	public String getInstrumentName() {
		return InstrumentName;
	}
	public IssuerInfo getIssuer() {
		return Issuer;
	}
	public BigDecimal getAmount() {
		return Amount;
	}
	public Integer getInstallments() {
		return Installments;
	}
	public Currency getCurrency() {
		return Currency;
	}
	public Boolean getIsAnonymous() {
		return IsAnonymous;
	}
	public TransactionType getCurrentState() {
		return CurrentState;
	}
	public String getInvoiceNumber() {
		return InvoiceNumber;
	}
	public FinancialInclusionResult getFinancialInclusion() {
		return FinancialInclusion;
	}
	public HashMap<TransactionType, TransactionInfo> getTransactions() {
		return Transactions;
	}
	public HashMap<FieldType, String> getFieldInformation() {
		return FieldInformation;
	}
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
	public void setCommerce(Commerce commerce) {
		this.Commerce = commerce;
	}
	public void setInstrumentToken(String instrumentToken) {
		this.InstrumentToken = instrumentToken;
	}
	public void setInstrumentName(String instrumentName) {
		this.InstrumentName = instrumentName;
	}
	public void setIssuer(IssuerInfo issuer) {
		this.Issuer = issuer;
	}
	public void setAmount(BigDecimal amount) {
		this.Amount = amount;
	}
	public void setInstallments(Integer installments) {
		this.Installments = installments;
	}
	public void setCurrency(Currency currency) {
		this.Currency = currency;
	}
	public void setIsAnonymous(Boolean isAnonymous) {
		IsAnonymous = isAnonymous;
	}
	public void setCurrentState(TransactionType currentState) {
		CurrentState = currentState;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		InvoiceNumber = invoiceNumber;
	}
	public void setFinancialInclusion(FinancialInclusionResult financialInclusion) {
		FinancialInclusion = financialInclusion;
	}
	public void setTransactions(HashMap<TransactionType, TransactionInfo> transactions) {
		Transactions = transactions;
	}
	public void setFieldInformation(HashMap<FieldType, String> fieldInformation) {
		FieldInformation = fieldInformation;
	}

}
