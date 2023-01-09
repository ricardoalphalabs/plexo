package uy.com.plexo.models;

import java.io.Serializable;

public class TimeLimit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1896764156040322255L;
    public int secondsLeft;
    public FieldType requirementAfterTimeLimit;
	public TimeLimit() {
		// TODO Auto-generated constructor stub
	}
	public int getSecondsLeft() {
		return secondsLeft;
	}
	public void setSecondsLeft(int secondsLeft) {
		this.secondsLeft = secondsLeft;
	}
	public FieldType getRequirementAfterTimeLimit() {
		return requirementAfterTimeLimit;
	}
	public void setRequirementAfterTimeLimit(FieldType requirementAfterTimeLimit) {
		this.requirementAfterTimeLimit = requirementAfterTimeLimit;
	}

}
