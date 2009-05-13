package org.swingbean.plugin.model;

import java.util.HashMap;
import java.util.Map;

public enum PropertyType {

	TEXT,
	LARGE_TEXT,
	PASSWORD,
	DATE,
	BOOLEAN,
	INTEGER,
	LONG,
	FLOAT,
	DOUBLE,
	COMBO,
	DEPENDENT_COMBO,
	MULTIPLE_LIST,
	CHECKBOX_LIST,
	IMAGE,
	COLOR,
	TREE;

	private static final Map<String, PropertyType> stringToEnum = new HashMap<String, PropertyType>();
	private static final String[] array = new String[values().length];
	
	static {
		int i = 0;
		for (PropertyType pt : values()) {
			stringToEnum.put(pt.name(), pt);
			array[i] = values()[i].name();
			i++;
		}
	}

	public static String[] getStringArray(){
		return array;
	}

	public static PropertyType fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

}
