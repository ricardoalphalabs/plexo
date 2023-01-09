package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class DisplayOptionsDto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Boolean titles;
    public Boolean details;
	public Boolean footer;
    public Boolean logo;
    public Boolean accessibility;
	public DisplayOptionsDto() {
		// TODO Auto-generated constructor stub
	}
	public Boolean getTitles() {
		return titles;
	}
	public Boolean getDetails() {
		return details;
	}
	public void setTitles(Boolean titles) {
		this.titles = titles;
	}
	public void setDetails(Boolean details) {
		this.details = details;
	}
	public Boolean getFooter() {
		return footer;
	}
	public Boolean getLogo() {
		return logo;
	}
	public Boolean getAccessibility() {
		return accessibility;
	}
	public void setFooter(Boolean footer) {
		this.footer = footer;
	}
	public void setLogo(Boolean logo) {
		this.logo = logo;
	}
	public void setAccessibility(Boolean accessibility) {
		this.accessibility = accessibility;
	}

}
