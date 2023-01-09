package uy.com.plexo.models.helpers;

import uy.com.plexo.models.ResultCodes;

public class SignatureException extends ResultCodeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1012044167543657956L;
	
	public SignatureException(String message){
		super(message,ResultCodes.InvalidSignature);
	}

}
