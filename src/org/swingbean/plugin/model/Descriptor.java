package org.swingbean.plugin.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "beanDescriptor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Descriptor {

	@XmlElement(name = "line")
	private List<Line> lines = new ArrayList<Line>();

	public void addLine(Line line){
		this.lines.add(line);
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void clearLines() {
		lines.clear();
	}

}
