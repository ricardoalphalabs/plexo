package uy.com.plexo.models;

import java.io.Serializable;

public class TransactionInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6377411279260410525L;
	public String clientReferenceId;
    public String clientMetadata;
	public TransactionResult status;
    public int transactionCode;
    public String transactionResultText;
    public long executionDateUTC;
    public String authorization;
    public String ticket;
    public long expirationUTC; //Case Use, when TransactionResult=Pending, or when Opearation is StartReserve
    
	public TransactionInfo() {
		// TODO Auto-generated constructor stub
	}
	
    public String getClientReferenceId() {
		return clientReferenceId;
	}
	public String getClientMetadata() {
		return clientMetadata;
	}
	public TransactionResult getStatus() {
		return status;
	}
	public int getTransactionCode() {
		return transactionCode;
	}
	public String getTransactionResultText() {
		return transactionResultText;
	}
	public long getExecutionDateUTC() {
		return executionDateUTC;
	}
	public String getAuthorization() {
		return authorization;
	}
	public String getTicket() {
		return ticket;
	}
	public long getExpirationUTC() {
		return expirationUTC;
	}
	public void setClientReferenceId(String clientReferenceId) {
		this.clientReferenceId = clientReferenceId;
	}
	public void setClientMetadata(String clientMetadata) {
		this.clientMetadata = clientMetadata;
	}
	public void setStatus(TransactionResult status) {
		this.status = status;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}
	public void setTransactionResultText(String transactionResultText) {
		this.transactionResultText = transactionResultText;
	}
	public void setExecutionDateUTC(long executionDateUTC) {
		this.executionDateUTC = executionDateUTC;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public void setExpirationUTC(long expirationUTC) {
		this.expirationUTC = expirationUTC;
	}


}
