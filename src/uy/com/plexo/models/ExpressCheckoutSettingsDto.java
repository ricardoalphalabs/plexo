package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ExpressCheckoutSettingsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DisplayOptionsDto display;
	public BuiltInPagesOptionsDto builtInPages;
	public ExpressCheckoutSettingsDto() {
		// TODO Auto-generated constructor stub
	}
	public DisplayOptionsDto getDisplay() {
		return display;
	}
	public void setDisplay(DisplayOptionsDto display) {
		this.display = display;
	}
	public BuiltInPagesOptionsDto getBuiltInPages() {
		return builtInPages;
	}
	public void setBuiltInPages(BuiltInPagesOptionsDto builtInPages) {
		this.builtInPages = builtInPages;
	}

}
