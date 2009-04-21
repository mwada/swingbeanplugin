package org.swingbean.plugin.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class ListProperty extends Property {

	@XmlAttribute
	private Boolean threadLoading;

	@XmlAttribute
	@XmlJavaTypeAdapter(value=ArrayTypeAdapter.class)
	private String[] list;

	@XmlAttribute
	private String listModelClass;

	@XmlAttribute
	private String listModelMethod;

	@XmlAttribute
	private String parameter;

	@XmlAttribute
	private Integer minSelected;

	@XmlAttribute
	private Integer maxSelected;

	public ListProperty(){
	}

	public ListProperty(String name, PropertyType type){
		super(name, type);
	}

	public Boolean getThreadLoading() {
		return threadLoading;
	}

	public void setThreadLoading(Boolean threadLoading) {
		this.threadLoading = threadLoading;
	}

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}

	public String getListModelClass() {
		return listModelClass;
	}

	public void setListModelClass(String listModelClass) {
		this.listModelClass = listModelClass;
	}

	public String getListModelMethod() {
		return listModelMethod;
	}

	public void setListModelMethod(String listModelMethod) {
		this.listModelMethod = listModelMethod;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public Integer getMinSelected() {
		return minSelected;
	}

	public void setMinSelected(Integer minSelected) {
		this.minSelected = minSelected;
	}

	public Integer getMaxSelected() {
		return maxSelected;
	}

	public void setMaxSelected(Integer maxSelected) {
		this.maxSelected = maxSelected;
	}



}
