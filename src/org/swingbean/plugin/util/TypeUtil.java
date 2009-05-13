package org.swingbean.plugin.util;

import java.awt.Color;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.swingbean.plugin.model.PropertyType;

public class TypeUtil {

	private static final Map<String, PropertyType> defaultTypes = new HashMap<String, PropertyType>(); 
	private static final Map<String, Class> defaultClasses = new HashMap<String, Class>(); 

	static {
		defaultTypes.put("Object", PropertyType.TEXT);
		defaultTypes.put("String", PropertyType.TEXT);
		defaultTypes.put("Date", PropertyType.DATE);
		defaultTypes.put("Color", PropertyType.COLOR);
		defaultTypes.put("Integer", PropertyType.INTEGER);
		defaultTypes.put("int", PropertyType.INTEGER);
		defaultTypes.put("Long", PropertyType.LONG);
		defaultTypes.put("long", PropertyType.LONG);
		defaultTypes.put("Float", PropertyType.FLOAT);
		defaultTypes.put("float", PropertyType.FLOAT);
		defaultTypes.put("Double", PropertyType.DOUBLE);
		defaultTypes.put("double", PropertyType.DOUBLE);
		defaultTypes.put("boolean", PropertyType.BOOLEAN);
		defaultTypes.put("Boolean", PropertyType.BOOLEAN);
		defaultTypes.put("byte[]", PropertyType.IMAGE);

		defaultClasses.put("Object", Object.class);
		defaultClasses.put("String", String.class);
		defaultClasses.put("Date", Date.class);
		defaultClasses.put("Color", Color.class);
		defaultClasses.put("Integer", Integer.class);
		defaultClasses.put("int", int.class);
		defaultClasses.put("Long", Long.class);
		defaultClasses.put("long", long.class);
		defaultClasses.put("Float", Float.class);
		defaultClasses.put("float", float.class);
		defaultClasses.put("Double", Double.class);
		defaultClasses.put("double", double.class);
		defaultClasses.put("boolean", boolean.class);
		defaultClasses.put("Boolean", Boolean.class);
		defaultClasses.put("byte[]", byte[].class);
}
	
	public static PropertyType getDefaultType(String className) {
		if (defaultTypes.get(className) == null) return PropertyType.TEXT;
		return defaultTypes.get(className);
	}

	public static Class getClassType(String className) {
		if (defaultClasses.get(className) == null) return Object.class;
		return defaultClasses.get(className);
	}

}