package org.swingbean.plugin.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ArrayTypeAdapter extends XmlAdapter<String, String[]> {

	@Override
	public String marshal(String[] parameters) throws Exception {
		if (parameters==null || parameters.length==0) return null;
		StringBuffer parametersString = new StringBuffer();
		for(String parameter: parameters){
			parametersString.append(parameter+";");
		}
		if(parametersString.length()>0){
			parametersString.deleteCharAt(parametersString.length()-1);
		}
		return parametersString.toString();
	}

	@Override
	public String[] unmarshal(String parametersString) throws Exception {
		return parametersString.split(";");
	}

}
