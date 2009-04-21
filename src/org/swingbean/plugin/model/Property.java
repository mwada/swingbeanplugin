package org.swingbean.plugin.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Property {

	@XmlAttribute
	private String name;

	@XmlAttribute
	private String label;

	@XmlAttribute
	private PropertyType type;

	@XmlAttribute
	private Integer colspan;

	@XmlAttribute
	private Integer columnSize;

	@XmlAttribute
	private Boolean readOnly;

	@XmlAttribute
	private Boolean mandatory;

	public Property(){
	}

	public Property(String name, PropertyType type){
		this.name = name;
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public PropertyType getType() {
		return type;
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	public Integer getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(Integer columnSize) {
		this.columnSize = columnSize;
	}

	public Boolean getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public String getName() {
		return name;
	}

}
