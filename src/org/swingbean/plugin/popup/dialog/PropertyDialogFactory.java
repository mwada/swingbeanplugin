package org.swingbean.plugin.popup.dialog;

import org.eclipse.swt.widgets.Shell;
import org.swingbean.plugin.model.Property;

public class PropertyDialogFactory {

	public static PropertyDialog getDialog(Shell parentShell, Property property){
		switch(property.getType()){
			case TEXT:
			case LARGE_TEXT:
			case PASSWORD:
				return new TextPropertyDialog(parentShell, property);

			case COMBO:
				return new ComboPropertyDialog(parentShell, property);

			case DEPENDENT_COMBO:
				return new DependentComboPropertyDialog(parentShell, property);

			case IMAGE:
				return new ImagePropertyDialog(parentShell, property);

			case INTEGER:
			case LONG:
			case FLOAT:
			case DOUBLE:
				return new NumberPropertyDialog(parentShell, property);

			case MULTIPLE_LIST:
			case CHECKBOX_LIST:
				return new ListPropertyDialog(parentShell, property);

			case TREE:
				return new TreePropertyDialog(parentShell, property);

			case DATE:
			case BOOLEAN:
			case COLOR:
			default:
		}
		return new PropertyDialog(parentShell, property);
	}


}
