package org.swingbean.plugin.popup.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.swingbean.plugin.model.NumberProperty;
import org.swingbean.plugin.model.Property;

public class NumberPropertyDialog extends PropertyDialog{

	private Text max;
	private Text min;

	protected NumberPropertyDialog(Shell parentShell, Property property) {
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
	    label.setText("Max");
	    max = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    max.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Min");
	    min = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    min.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    return result;

	  }

	protected void fillProperty(){
		super.fillProperty();
		NumberProperty numberProperty = (NumberProperty) this.property;

		if (checkValid(min))
			numberProperty.setMin(Integer.getInteger(min.getText()));
		if (checkValid(max))
			numberProperty.setMax(Integer.getInteger(max.getText()));
	}

}
