package org.swingbean.plugin.popup.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.swingbean.plugin.model.ComboProperty;
import org.swingbean.plugin.model.Property;

public class ComboPropertyDialog extends PropertyDialog{

	private Combo threadLoading;
	private Text comboList;
	private Text comboModelClass;

	protected ComboPropertyDialog(Shell parentShell, Property property) {
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
	    label.setText("Thread Loading");
	    threadLoading = new Combo(panel, SWT.BORDER | SWT.READ_ONLY);
	    threadLoading.setItems(booleans);
	    threadLoading.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Combo List");
	    comboList = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    comboList.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Combo Model Class");
	    comboModelClass = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    comboModelClass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    return result;

	  }

	protected void fillProperty(){
		super.fillProperty();
		ComboProperty comboProperty = (ComboProperty) this.property;
		if (checkValid(threadLoading))
			comboProperty.setThreadLoading(Boolean.getBoolean(threadLoading.getText()));
		if (checkValid(comboList))
			comboProperty.setComboList(comboList.getText());
		if (checkValid(comboModelClass))
			comboProperty.setComboModelClass(comboModelClass.getText());
	}

}
