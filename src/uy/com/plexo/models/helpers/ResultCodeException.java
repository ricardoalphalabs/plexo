package uy.com.plexo.models.helpers;

import uy.com.plexo.models.ResultCodes;

public class ResultCodeException extends Exception {

	private static final long serialVersionUID = -5006926095108083559L;
	public ResultCodes code;
	
	public ResultCodeException() {
	}


	public ResultCodeException(String message, ResultCodes code) {
		super(message);
		this.code=code;
	}


}
