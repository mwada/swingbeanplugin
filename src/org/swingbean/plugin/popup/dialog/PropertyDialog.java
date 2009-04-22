package org.swingbean.plugin.popup.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.swingbean.plugin.model.Property;

public class PropertyDialog extends Dialog {

	protected Property property;

	protected Text textLabel;
	protected Text colspan;
	protected Text columnSize;
	protected Combo readOnly;
	protected Combo mandatory;

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
		colspan = new Text(panel, SWT.SINGLE | SWT.BORDER);
		colspan.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		colspan.addModifyListener(new IntegerListener());

		label = new Label(panel, SWT.NONE);
		label.setText("ColumnSize");
		columnSize = new Text(panel, SWT.SINGLE | SWT.BORDER);
		columnSize.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		columnSize.addModifyListener(new IntegerListener());


		label = new Label(panel, SWT.NONE);
		label.setText("ReadOnly");
		readOnly = new Combo(panel, SWT.BORDER | SWT.READ_ONLY);
		readOnly.setItems(booleans);
		readOnly.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		label = new Label(panel, SWT.NONE);
		label.setText("Mandatory");
		mandatory = new Combo(panel, SWT.BORDER | SWT.READ_ONLY);
		mandatory.setItems(booleans);
		mandatory.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		initWidgetValues();

		return result;

	}

	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);
		return result;
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

	protected void initWidgetValues() {
		if (notEmpty(property.getLabel()))
			textLabel.setText(property.getLabel());
		if (notEmpty(property.getColspan()))
			colspan.setText(property.getColspan().toString());
		if (notEmpty(property.getColumnSize()))
			columnSize.setText(property.getColumnSize().toString());
		if (notEmpty(property.getReadOnly()))
			readOnly.setText(property.getReadOnly().toString());
		if (notEmpty(property.getMandatory()))
			mandatory.setText(property.getMandatory().toString());
	}

	protected void fillProperty(){
		if (notEmpty(textLabel))
			property.setLabel(textLabel.getText());
		if (notEmpty(colspan))
			property.setColspan(Integer.parseInt(colspan.getText()));
		if (notEmpty(columnSize))
			property.setColumnSize(Integer.parseInt(columnSize.getText()));
		if (notEmpty(readOnly))
			property.setReadOnly(Boolean.parseBoolean(readOnly.getText()));
		if (notEmpty(mandatory))
			property.setMandatory(Boolean.parseBoolean(mandatory.getText()));
	}

	protected boolean notEmpty(Text text){
		return text!=null && text.getText().trim().length() > 0;
	}

	protected boolean notEmpty(Combo combo){
		return combo!=null && combo.getText().trim().length() > 0;
	}

	protected boolean notEmpty(String s){
		return s!=null && s.trim().length() > 0;
	}

	protected boolean notEmpty(Integer i){
		return i!=null;
	}

	protected boolean notEmpty(Boolean b){
		return b!=null;
	}

	class IntegerListener implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			Text text = (Text) e.getSource();
			try{
				if (!"".equals(text.getText()))
				Integer.parseInt(text.getText());
			}catch(Exception ex){
				text.setText("");
			}
		}
	}

}
