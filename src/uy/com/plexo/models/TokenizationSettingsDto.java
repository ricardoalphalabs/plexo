package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class TokenizationSettingsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DisplayOptionsDto display;
	public TokenizationSettingsDto() {
		// TODO Auto-generated constructor stub
	}
	public DisplayOptionsDto getDisplay() {
		return display;
	}
	public void setDisplay(DisplayOptionsDto display) {
		this.display = display;
	}

}
