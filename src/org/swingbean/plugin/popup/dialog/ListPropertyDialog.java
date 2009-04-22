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
import org.swingbean.plugin.model.ListProperty;
import org.swingbean.plugin.model.Property;

public class ListPropertyDialog extends PropertyDialog{

	private Combo threadLoading;
	private Text list;
	private Text listModelClass;
	private Text listModelMethod;
	private Text parameter;
	private Text minSelected;
	private Text maxSelected;

	protected ListPropertyDialog(Shell parentShell, Property property) {
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
	    label.setText("List");
	    list = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    list.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("List Model Class");
	    listModelClass = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    listModelClass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("List Model Method");
	    listModelMethod = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    listModelMethod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Parameter");
	    parameter = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    parameter.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Min Selected");
	    minSelected = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    minSelected.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Max Selected");
	    maxSelected = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    maxSelected.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    return result;

	  }

	protected void fillProperty(){
		super.fillProperty();
		ListProperty listProperty = (ListProperty) this.property;

		if (checkValid(threadLoading))
			listProperty.setThreadLoading(Boolean.getBoolean(threadLoading.getText()));
		//if (checkValid(list))
			//listProperty.setList(list.getText());
		if (checkValid(listModelClass))
			listProperty.setListModelClass(listModelClass.getText());
		if (checkValid(listModelMethod))
			listProperty.setListModelMethod(listModelMethod.getText());
		if (checkValid(parameter))
			listProperty.setParameter(parameter.getText());
		if (checkValid(minSelected))
			listProperty.setMinSelected(Integer.getInteger(minSelected.getText()));
		if (checkValid(maxSelected))
			listProperty.setMaxSelected(Integer.getInteger(maxSelected.getText()));
	}

}
