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
        @XmlElement(name = "property", type = ComboProperty.class),
        @XmlElement(name = "property", type = DependentComboProperty.class),
        @XmlElement(name = "property", type = ImageProperty.class),
        @XmlElement(name = "property", type = ListProperty.class),
        @XmlElement(name = "property", type = NumberProperty.class),
        @XmlElement(name = "property", type = TextProperty.class),
        @XmlElement(name = "property", type = TreeProperty.class)
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
