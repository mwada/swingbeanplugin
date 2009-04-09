package org.swingbean.plugin.model;

import javax.xml.bind.annotation.XmlAttribute;

public class DependentComboProperty  extends Property {

	@XmlAttribute
	private String comboModelClass;

	@XmlAttribute
	private String dependentProperty;

	public String getComboModelClass() {
		return comboModelClass;
	}
	public void setComboModelClass(String comboModelClass) {
		this.comboModelClass = comboModelClass;
	}
	public String getDependentProperty() {
		return dependentProperty;
	}
	public void setDependentProperty(String dependentProperty) {
		this.dependentProperty = dependentProperty;
	}

}
