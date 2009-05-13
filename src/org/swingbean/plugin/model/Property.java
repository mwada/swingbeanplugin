package org.swingbean.plugin.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

@XmlAccessorType(XmlAccessType.FIELD)
public class Property {

	@XmlAttribute
	private String name;

	@XmlAttribute
	private PropertyType type;
	
	@XmlTransient
	private Map<String,Object> attributes = new HashMap<String,Object>();

	@XmlAnyAttribute
	private Map<QName,String> attributesXml = new HashMap<QName,String>();

	public Property(){
	}

	public Property(String name, PropertyType type){
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public PropertyType getType() {
		return type;
	}

	public void setAttribute(String key, Object value){
		if (attributes.containsKey(key)){
			removeAttribute(key);
		}
		attributes.put(key, value);
		if (value != null){
			attributesXml.put(new QName(key), value.toString());
		}
	}

	public Object getAttribute(String key){
		return attributes.get(key);
	}

	public Set<String> ketSetAttribute(){
		return attributes.keySet();
	}
	
	public Object removeAttribute(String key){
		attributesXml.remove(new QName(key));
		return attributes.remove(key);
	}

}
