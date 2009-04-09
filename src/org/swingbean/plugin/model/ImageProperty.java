package org.swingbean.plugin.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImageProperty extends Property {

	@XmlAttribute
	private Boolean showResolution;

	@XmlAttribute
	private Boolean saveResolution;

	public Boolean getShowResolution() {
		return showResolution;
	}
	public void setShowResolution(Boolean showResolution) {
		this.showResolution = showResolution;
	}
	public Boolean getSaveResolution() {
		return saveResolution;
	}
	public void setSaveResolution(Boolean saveResolution) {
		this.saveResolution = saveResolution;
	}

}
