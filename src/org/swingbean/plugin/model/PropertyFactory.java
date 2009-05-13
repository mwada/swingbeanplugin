package org.swingbean.plugin.model;

public class PropertyFactory {
	
	public static Property getProperty(String name, PropertyType type){
		Property property = new Property(name, type);
		property.setAttribute("label", null);
		property.setAttribute("colspan", null);
		property.setAttribute("columnSize", null);
		property.setAttribute("readOnly", null);
		property.setAttribute("mandatory", null);

		switch(property.getType()){
		case TEXT:
		case LARGE_TEXT:
		case PASSWORD:
			property.setAttribute("size", null);
			property.setAttribute("minSize", null);
			property.setAttribute("pattern", null);
			property.setAttribute("mask", null);
			property.setAttribute("formatExample", null);
			break;
			
		case COMBO:
			property.setAttribute("threadLoading", null);
			property.setAttribute("comboList", null);
			property.setAttribute("comboModelClass", null);
			break;

		case DEPENDENT_COMBO:
			property.setAttribute("comboModelClass", null);
			property.setAttribute("dependentProperty", null);
			break;

		case IMAGE:
			property.setAttribute("showResolution", null);
			property.setAttribute("saveResolution", null);
			break;

		case INTEGER:
		case LONG:
		case FLOAT:
		case DOUBLE:
			property.setAttribute("max", null);
			property.setAttribute("min", null);
			break;

		case MULTIPLE_LIST:
		case CHECKBOX_LIST:
			property.setAttribute("threadLoading", null);
			property.setAttribute("list", null);
			property.setAttribute("listModelClass", null);
			property.setAttribute("listModelMethod", null);
			property.setAttribute("parameter", null);
			property.setAttribute("minSelected", null);
			property.setAttribute("maxSelected", null);
			break;

		case TREE:
			property.setAttribute("rootName", null);
			property.setAttribute("idProperty", null);
			property.setAttribute("parentProperty", null);
			property.setAttribute("childrenProperty", null);
			property.setAttribute("classifyBy", null);
			break;

		case DATE:
		case BOOLEAN:
		case COLOR:
		default:
	}
		return property;
	}

}
