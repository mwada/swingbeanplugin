package org.swingbean.plugin.popup.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.swingbean.plugin.model.ImageProperty;
import org.swingbean.plugin.model.Property;

public class ImagePropertyDialog extends PropertyDialog{

	private Combo showResolution;
	private Combo saveResolution;

	protected ImagePropertyDialog(Shell parentShell, Property property) {
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
	    label.setText("Show Resolution");
	    showResolution = new Combo(panel, SWT.BORDER | SWT.READ_ONLY);
	    showResolution.setItems(booleans);
	    showResolution.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label.setText("Save Resolution");
	    saveResolution = new Combo(panel, SWT.BORDER | SWT.READ_ONLY);
	    saveResolution.setItems(booleans);
	    saveResolution.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    initWidgetValues();

	    return result;

	  }

	protected void fillProperty(){
		super.fillProperty();
		ImageProperty imageProperty = (ImageProperty) this.property;
		if (notEmpty(showResolution))
			imageProperty.setShowResolution(Boolean.parseBoolean(showResolution.getText()));
		if (notEmpty(saveResolution))
			imageProperty.setSaveResolution(Boolean.parseBoolean(saveResolution.getText()));
	}

}
