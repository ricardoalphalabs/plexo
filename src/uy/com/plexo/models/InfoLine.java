package uy.com.plexo.models;

import java.io.Serializable;

public class InfoLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9126315361892684900L;
    public String text;
    public double amount;
	public InfoLine() {
		// TODO Auto-generated constructor stub
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
