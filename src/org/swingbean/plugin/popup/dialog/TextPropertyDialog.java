package org.swingbean.plugin.popup.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.swingbean.plugin.model.Property;
import org.swingbean.plugin.model.TextProperty;

public class TextPropertyDialog extends PropertyDialog{

	private Text size;
	private Text minSize;
	private Text pattern;
	private Text mask;
	private Text formatExample;

	protected TextPropertyDialog(Shell parentShell, Property property) {
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
	    label.setText("Size");
	    size = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    size.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    size.addModifyListener(new IntegerListener());

	    label = new Label(panel, SWT.NONE);
	    label.setText("Min Size");
	    minSize = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    minSize.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    size.addModifyListener(new IntegerListener());

	    label = new Label(panel, SWT.NONE);
	    label.setText("Pattern");
	    pattern = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    pattern.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Mask");
	    mask = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    mask.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Format Example");
	    formatExample = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    formatExample.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    initWidgetValues();

	    return result;
	  }

	  protected void fillProperty(){
		  super.fillProperty();
		TextProperty textProperty = (TextProperty) this.property;
		if (notEmpty(size))
			textProperty.setSize(Integer.parseInt(size.getText()));
		if (notEmpty(minSize))
			textProperty.setMinSize(Integer.parseInt(minSize.getText()));
		if (notEmpty(pattern))
			textProperty.setPattern(pattern.getText());
		if (notEmpty(mask))
			textProperty.setMask(mask.getText());
		if (notEmpty(formatExample))
			textProperty.setFormatExample(formatExample.getText());
 	  }


}
