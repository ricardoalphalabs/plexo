package uy.com.plexo.models;

import java.io.Serializable;

public class FieldInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -396895150483713447L;

    public String labelName;
    public FieldType fieldType;
    public boolean required;
	public FieldInfo() {
		// TODO Auto-generated constructor stub
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public FieldType getFieldType() {
		return fieldType;
	}
	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}

}
