package uy.com.plexo.models;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class ServerResponseData <T> extends SignedObjectGeneric<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2784170745274958281L;
	private ResultCodes ResultCode;
    private String ErrorMessage;
    public Map<String,String> i18NErrorMessages;
	public ServerResponseData() {
		// TODO Auto-generated constructor stub
	}

	public ResultCodes getResultCode() {
		return ResultCode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setResultCode(ResultCodes resultCode) {
		ResultCode = resultCode;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public Map<String, String> getI18NErrorMessages() {
		return i18NErrorMessages;
	}

	public void setI18NErrorMessages(Map<String, String> i18nErrorMessages) {
		i18NErrorMessages = i18nErrorMessages;
	}
}
