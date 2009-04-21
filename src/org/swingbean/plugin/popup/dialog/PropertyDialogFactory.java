package org.swingbean.plugin.popup.dialog;

import org.eclipse.swt.widgets.Shell;
import org.swingbean.plugin.model.Property;

public class PropertyDialogFactory {

	public static PropertyDialog getDialog(Shell parentShell, Property property){
		switch(property.getType()){
			case TEXT:
			case LARGE_TEXT:
			case PASSWORD:
				new TextPropertyDialog(parentShell, property);

			case COMBO:

			case DEPENDENT_COMBO:

			case IMAGE:

			case INTEGER:
			case LONG:
			case FLOAT:
			case DOUBLE:

			case MULTIPLE_LIST:
			case CHECKBOX_LIST:

			case TREE:

			case DATE:
			case BOOLEAN:
			case COLOR:
			default:
		}
		return new PropertyDialog(parentShell, property);
	}


}
