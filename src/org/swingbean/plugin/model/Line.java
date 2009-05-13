package org.swingbean.plugin.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

@XmlAccessorType(XmlAccessType.FIELD)
public class Line {

	@XmlElements({
        @XmlElement(name = "property", type = Property.class)
    })
	private List<Property> properties = new ArrayList<Property>();

	public void addProperty(Property property){
		this.properties.add(property);
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public List<Property> getProperties() {
		return properties;
	}

}
