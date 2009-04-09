package org.swingbean.plugin.model;

import javax.xml.bind.annotation.XmlAttribute;

public class ComboProperty extends Property {

	@XmlAttribute
	private Boolean threadLoading;

	@XmlAttribute
	private String comboList;

	@XmlAttribute
	private String comboModelClass;

	public Boolean getThreadLoading() {
		return threadLoading;
	}
	public void setThreadLoading(Boolean threadLoading) {
		this.threadLoading = threadLoading;
	}
	public String getComboList() {
		return comboList;
	}
	public void setComboList(String comboList) {
		this.comboList = comboList;
	}
	public String getComboModelClass() {
		return comboModelClass;
	}
	public void setComboModelClass(String comboModelClass) {
		this.comboModelClass = comboModelClass;
	}
	public String[] getComboModelMethod() {
		return comboModelMethod;
	}
	public void setComboModelMethod(String[] comboModelMethod) {
		this.comboModelMethod = comboModelMethod;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	private String[] comboModelMethod;
	private String parameter;
}
