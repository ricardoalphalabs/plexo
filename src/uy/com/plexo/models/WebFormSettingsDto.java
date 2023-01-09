package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class WebFormSettingsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public UIOptionsDto uI;
    public ExpressCheckoutSettingsDto expressCheckout;
    public TokenizationSettingsDto tokenization;

	public WebFormSettingsDto() {
		// TODO Auto-generated constructor stub
	}

	public UIOptionsDto getuI() {
		return uI;
	}

	public ExpressCheckoutSettingsDto getExpressCheckout() {
		return expressCheckout;
	}

	public void setuI(UIOptionsDto uI) {
		this.uI = uI;
	}

	public void setExpressCheckout(ExpressCheckoutSettingsDto expressCheckout) {
		this.expressCheckout = expressCheckout;
	}

	public TokenizationSettingsDto getTokenization() {
		return tokenization;
	}

	public void setTokenization(TokenizationSettingsDto tokenization) {
		this.tokenization = tokenization;
	}

}
