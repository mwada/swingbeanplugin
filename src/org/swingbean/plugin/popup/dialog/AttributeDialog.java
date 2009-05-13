package org.swingbean.plugin.popup.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.swingbean.plugin.model.Property;

public class AttributeDialog extends Dialog {

	protected Table table;

	protected Property property;

	public Property getProperty() {
		return property;
	}


	protected Text attribute;
		
	public Text getAttribute() {
		return attribute;
	}

	protected AttributeDialog(Shell parentShell) {
		super(parentShell);
	}

	public AttributeDialog(Shell parentShell, Property property) {
		this(parentShell);
		this.property = property;
	}

	/*
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	protected void okPressed() {
		property.setAttribute(attribute.getText(), null);
		super.okPressed();
	}

	/*
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	protected void cancelPressed() {
		super.cancelPressed();
	}

	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);
	    validateInput();
		return result;
	}

	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("Add Attribute");
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
		label.setText("Attribute:");
		attribute = new Text(panel, SWT.SINGLE | SWT.BORDER);
		attribute.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		attribute.addModifyListener(new ModifyListener()
	      {
	        public void modifyText(ModifyEvent e)
	        {
	          validateInput();
	        }
	      });
		
		return result;

	}
	
	
	
	private void validateInput()
	  {
	    boolean enabled = attribute.getText().trim().length() > 0;
	    getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	  }


}
