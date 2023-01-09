package uy.com.plexo.models;

import java.io.Serializable;

public class Currency implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6138768646759388801L;

	public int currencyId;
    public String name;
    public String plural;
    public String symbol;
	public Currency() {
		// TODO Auto-generated constructor stub
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlural() {
		return plural;
	}
	public void setPlural(String plural) {
		this.plural = plural;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
