package uy.com.plexo.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder(alphabetic=true)
public class Query implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7037732976270039738L;
    public QueryOperation queryOperator;
    public TransactionField field;
    public TransactionOperator operator;
    public String value;
    public List<Query> subQueries;

	public Query() {
		// TODO Auto-generated constructor stub
	}

	public QueryOperation getQueryOperator() {
		return queryOperator;
	}

	public TransactionField getField() {
		return field;
	}

	public TransactionOperator getOperator() {
		return operator;
	}

	public String getValue() {
		return value;
	}

	public List<Query> getSubQueries() {
		return subQueries;
	}

	public void setQueryOperator(QueryOperation queryOperator) {
		this.queryOperator = queryOperator;
	}

	public void setField(TransactionField field) {
		this.field = field;
	}

	public void setOperator(TransactionOperator operator) {
		this.operator = operator;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setSubQueries(List<Query> subQueries) {
		this.subQueries = subQueries;
	}

}
