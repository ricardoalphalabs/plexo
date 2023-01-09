package uy.com.plexo.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement
@JsonPropertyOrder(alphabetic=true)
public class BuiltInPagesOptionsDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Boolean checkoutSuccessPage;
	public Boolean checkoutErrorPage;

	public BuiltInPagesOptionsDto  (){
		// TODO Auto-generated constructor stub
	}

	public Boolean getCheckoutSuccessPage() {
		return checkoutSuccessPage;
	}

	public Boolean getCheckoutErrorPage() {
		return checkoutErrorPage;
	}

	public void setCheckoutSuccessPage(Boolean checkoutSuccessPage) {
		this.checkoutSuccessPage = checkoutSuccessPage;
	}

	public void setCheckoutErrorPage(Boolean checkoutErrorPage) {
		this.checkoutErrorPage = checkoutErrorPage;
	}

}
