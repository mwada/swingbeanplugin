package org.swingbean.plugin.model;

import javax.xml.bind.annotation.XmlAttribute;

public class NumberProperty extends Property {

	@XmlAttribute
	private Integer max;

	@XmlAttribute
	private Integer min;

	public NumberProperty(){
	}

	public NumberProperty(String name, PropertyType type){
		super(name, type);
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

}
