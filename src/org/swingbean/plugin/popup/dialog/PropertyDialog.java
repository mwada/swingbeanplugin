package org.swingbean.plugin.popup.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.swingbean.plugin.model.Property;

public class PropertyDialog extends Dialog{

	protected Property property;

	protected Text textLabel;
	protected Text textColspan;
	protected Text textColumnSize;
	protected Combo comboReadOnly;
	protected Combo comboMandatory;

	final static String[] booleans = {"true", "false"};

	protected PropertyDialog(Shell parentShell) {
		super(parentShell);
	}

	protected PropertyDialog(Shell parentShell, Property property) {
		this(parentShell);
		this.property = property;
	}


	/*
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	protected void okPressed() {
		fillProperty();
		super.okPressed();
	}

	/*
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	protected void cancelPressed() {
		super.cancelPressed();
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(Composite)
	 */
	protected Control createDialogArea(Composite parent)
	  {
	    Composite result = (Composite)super.createDialogArea(parent);
	    Composite panel = new Composite(result, SWT.NONE);
	    panel.setLayout(new GridLayout(2, false));
	    panel.setLayoutData(new GridData(GridData.FILL_BOTH));

	    Label label = new Label(panel, SWT.NONE);
	    label.setText("Name");
	    Text textName = new Text(panel, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
	    textName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    textName.setText(property.getName());
	    label = new Label(panel, SWT.NONE);
	    label.setText("Type");
	    Text textType = new Text(panel, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
	    textType.setText(property.getType().name());
	    textType.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Label");
	    textLabel = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    textLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Colspan");
	    textColspan = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    textColspan.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("ColumnSize");
	    textColumnSize = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    textColumnSize.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));


	    label = new Label(panel, SWT.NONE);
	    label.setText("ReadOnly");
	    comboReadOnly = new Combo(panel, SWT.BORDER | SWT.READ_ONLY);
	    comboReadOnly.setItems(booleans);
	    comboReadOnly.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Mandatory");
	    comboMandatory = new Combo(panel, SWT.BORDER | SWT.READ_ONLY);
	    comboMandatory.setItems(booleans);
	    comboMandatory.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    initWidgetValues();

	    return result;

	  }

	  protected Control createContents(Composite parent)
	  {
	    Control result = super.createContents(parent);
	    return result;
	  }

	  private void initWidgetValues() {
		 /*
	    if (getAttribute() == null)
	    {
	      throw new IllegalStateException("Attribute not set; cannot initialize");
	    }*/
	  }

	  protected boolean checkValid(Text text){
		  return text!=null && text.getText().trim().length() > 0;
	  }

	  protected boolean checkValid(Combo combo){
		  return combo!=null && combo.getText().trim().length() > 0;
	  }

	  protected void configureShell(Shell newShell)
	  {
	    super.configureShell(newShell);
	    newShell.setText("Edit Property");
	  }


	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	protected void fillProperty(){
		if (checkValid(textLabel))
			property.setLabel(textLabel.getText());
		if (checkValid(textColspan))
			property.setColspan(Integer.getInteger(textColspan.getText()));
		if (checkValid(textColumnSize))
			property.setColumnSize(Integer.getInteger(textColumnSize.getText()));
		if (checkValid(comboReadOnly))
			property.setReadOnly(Boolean.getBoolean(comboReadOnly.getText()));
		if (checkValid(comboMandatory))
			property.setMandatory(Boolean.getBoolean(comboMandatory.getText()));
	}





}
