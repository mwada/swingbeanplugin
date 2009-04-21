package org.swingbean.plugin.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class TextProperty extends Property {

	@XmlAttribute
	private Integer size;

	@XmlAttribute
	private Integer minSize;

	@XmlAttribute
	private String pattern;

	@XmlAttribute
	private String mask;

	@XmlAttribute
	private String formatExample;

	public TextProperty(){
	}

	public TextProperty(String name, PropertyType type){
		super(name, type);
	}

	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getMinSize() {
		return minSize;
	}
	public void setMinSize(Integer minSize) {
		this.minSize = minSize;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public String getFormatExample() {
		return formatExample;
	}
	public void setFormatExample(String formatExample) {
		this.formatExample = formatExample;
	}



}
