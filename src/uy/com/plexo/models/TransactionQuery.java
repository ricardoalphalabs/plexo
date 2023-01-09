package uy.com.plexo.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder(alphabetic=true)
public class TransactionQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4486229336649079389L;

	public Integer limit;
	public List<TransactionOrder> order;
	public List<Query> queries;
	public Integer skip;
	
	public TransactionQuery() {
		// TODO Auto-generated constructor stub
	}

	public Integer getLimit() {
		return limit;
	}

	public List<TransactionOrder> getOrder() {
		return order;
	}

	public List<Query> getQueries() {
		return queries;
	}

	public Integer getSkip() {
		return skip;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setOrder(List<TransactionOrder> order) {
		this.order = order;
	}

	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}

	public void setSkip(Integer skip) {
		this.skip = skip;
	}



    
}
