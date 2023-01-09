package uy.com.plexo.models;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class UIOptionsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public Map<String, String> colors;
    public String theme;
    public Boolean autoDarkTheme;
    public String logoURL;

	public UIOptionsDto() {
		// TODO Auto-generated constructor stub
	}

	public Map<String, String> getColors() {
		return colors;
	}

	public String getTheme() {
		return theme;
	}

	public Boolean getAutoDarkTheme() {
		return autoDarkTheme;
	}

	public void setColors(Map<String, String> colors) {
		this.colors = colors;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setAutoDarkTheme(Boolean autoDarkTheme) {
		this.autoDarkTheme = autoDarkTheme;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

}
