package uy.com.plexo.models;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerResponseGeneric <T> extends ServerResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7389636046504528757L;
	private T object;
    public Map<String,String> i18NErrorMessages;

	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public Map<String, String> getI18NErrorMessages() {
		return i18NErrorMessages;
	}
	public void setI18NErrorMessages(Map<String, String> i18nErrorMessages) {
		i18NErrorMessages = i18nErrorMessages;
	}

	

}
