package uy.com.plexo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2991410852314768094L;
    public String clientItemReferenceId;
    public BigDecimal amount;
    public List<InfoLine> infoLines;
    public String metaData;
    public List<String> tags;
    //comentar para MX
    public String description;
    public int quantity;
    public String name;
    
    public Item() {
		// TODO Auto-generated constructor stub
	}
	public String getClientItemReferenceId() {
		return clientItemReferenceId;
	}
	public void setClientItemReferenceId(String clientItemReferenceId) {
		this.clientItemReferenceId = clientItemReferenceId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public List<InfoLine> getInfoLines() {
		return infoLines;
	}
	public void setInfoLines(List<InfoLine> infoLines) {
		this.infoLines = infoLines;
	}
	public String getMetaData() {
		return metaData;
	}
	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	//comentar en MX
	public String getDescription() {
		return description;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getName() {
		return name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setName(String name) {
		this.name = name;
	}

}
