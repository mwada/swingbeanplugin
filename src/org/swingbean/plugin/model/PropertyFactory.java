package org.swingbean.plugin.model;

public class PropertyFactory {

	public static Property getProperty(String name, PropertyType type){
		switch(type){
		case TEXT:
		case LARGE_TEXT:
		case PASSWORD:
			return new TextProperty(name, type);

		case COMBO:
			return new ComboProperty(name, type);

		case DEPENDENT_COMBO:
			return new DependentComboProperty(name, type);

		case IMAGE:
			return new ImageProperty(name, type);

		case INTEGER:
		case LONG:
		case FLOAT:
		case DOUBLE:
			return new NumberProperty(name, type);

		case MULTIPLE_LIST:
		case CHECKBOX_LIST:
			return new ListProperty(name, type);

		case TREE:
			return new TreeProperty(name, type);

		case DATE:
		case BOOLEAN:
		case COLOR:
		default:
	}
	return new Property(name, type);

	}

}
