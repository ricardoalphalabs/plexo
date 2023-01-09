package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder(alphabetic=true)
public class PaymentCode implements Serializable {

	private static final long serialVersionUID = 1150265868654036813L;
	public String code;
    public String url;
    public long uTCUnixTimeExpiration;
	public PaymentCode() {
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public String getUrl() {
		return url;
	}
	public long getuTCUnixTimeExpiration() {
		return uTCUnixTimeExpiration;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setuTCUnixTimeExpiration(long uTCUnixTimeExpiration) {
		this.uTCUnixTimeExpiration = uTCUnixTimeExpiration;
	}

}
