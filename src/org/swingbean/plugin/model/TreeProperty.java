package org.swingbean.plugin.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class TreeProperty extends Property {

	@XmlAttribute
	private String rootName;

	@XmlAttribute
	private String idProperty;

	@XmlAttribute
	private String parentProperty;

	@XmlAttribute
	private String childrenProperty;

	@XmlAttribute
	@XmlJavaTypeAdapter(value=ArrayTypeAdapter.class)
	private String[] classifyBy;

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public String getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(String idProperty) {
		this.idProperty = idProperty;
	}

	public String getParentProperty() {
		return parentProperty;
	}

	public void setParentProperty(String parentProperty) {
		this.parentProperty = parentProperty;
	}

	public String getChildrenProperty() {
		return childrenProperty;
	}

	public void setChildrenProperty(String childrenProperty) {
		this.childrenProperty = childrenProperty;
	}

	public String[] getClassifyBy() {
		return classifyBy;
	}

	public void setClassifyBy(String[] classifyBy) {
		this.classifyBy = classifyBy;
	}


}
