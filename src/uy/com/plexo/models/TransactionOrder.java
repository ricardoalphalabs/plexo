package uy.com.plexo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder(alphabetic=true)
public class TransactionOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -39562268176131732L;
    public TransactionField field;
    public TransactionOrderDirection direction;

	public TransactionOrder() {
		// TODO Auto-generated constructor stub
	}

	public TransactionField getField() {
		return field;
	}

	public TransactionOrderDirection getDirection() {
		return direction;
	}

	public void setField(TransactionField field) {
		this.field = field;
	}

	public void setDirection(TransactionOrderDirection direction) {
		this.direction = direction;
	}

}
