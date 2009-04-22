package org.swingbean.plugin.popup.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.swingbean.plugin.model.DependentComboProperty;
import org.swingbean.plugin.model.Property;

public class DependentComboPropertyDialog extends PropertyDialog{

	private Text comboModelClass;
	private Text dependentProperty;

	protected DependentComboPropertyDialog(Shell parentShell, Property property) {
		super(parentShell, property);
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(Composite)
	 */
	protected Control createDialogArea(Composite parent) {
	    Composite result = (Composite)super.createDialogArea(parent);
	    Composite panel = new Composite(result, SWT.NONE);
	    panel.setLayout(new GridLayout(2, false));
	    panel.setLayoutData(new GridData(GridData.FILL_BOTH));

	    Label label = new Label(panel, SWT.NONE);
	    label.setText("Combo Model Class");
	    comboModelClass = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    comboModelClass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Dependent Property");
	    dependentProperty = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    dependentProperty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    return result;

	  }

	protected void fillProperty(){
		super.fillProperty();
		DependentComboProperty dependentComboProperty = (DependentComboProperty) this.property;
		if (checkValid(dependentProperty))
			dependentComboProperty.setDependentProperty(dependentProperty.getText());
		if (checkValid(comboModelClass))
			dependentComboProperty.setComboModelClass(comboModelClass.getText());
	}

}
