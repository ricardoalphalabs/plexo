package uy.com.plexo.models;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ServerResponse implements Serializable{
	private static final long serialVersionUID = -5694011064393815256L;
	
	public ResultCodes resultCode;
    public String errorMessage;
    public Map<String,String> i18NErrorMessages;
	public ServerResponse() {
		// TODO Auto-generated constructor stub
	}
	public ResultCodes getResultCode() {
		return resultCode;
	}
	public void setResultCode(ResultCodes resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Map<String, String> getI18NErrorMessages() {
		return i18NErrorMessages;
	}
	public void setI18NErrorMessages(Map<String, String> i18nErrorMessages) {
		i18NErrorMessages = i18nErrorMessages;
	}



	

}
