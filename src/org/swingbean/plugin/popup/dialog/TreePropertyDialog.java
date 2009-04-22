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
import org.swingbean.plugin.model.TreeProperty;

public class TreePropertyDialog extends PropertyDialog{

	private Text rootName;
	private Text idProperty;
	private Text parentProperty;
	private Text childrenProperty;
	private Text classifyBy;

	protected TreePropertyDialog(Shell parentShell, Property property) {
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
	    label.setText("Root Name");
	    rootName = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    rootName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Id Property");
	    idProperty = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    idProperty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Parent Property§");
	    parentProperty = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    parentProperty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Children Property");
	    childrenProperty = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    childrenProperty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    label = new Label(panel, SWT.NONE);
	    label.setText("Classify By");
	    classifyBy = new Text(panel, SWT.SINGLE | SWT.BORDER);
	    classifyBy.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    return result;

	  }

	  protected void fillProperty(){
		  super.fillProperty();
		TreeProperty treeProperty = (TreeProperty) this.property;
		if (checkValid(rootName))
			treeProperty.setRootName(rootName.getText());
		if (checkValid(idProperty))
			treeProperty.setIdProperty(idProperty.getText());
		if (checkValid(parentProperty))
			treeProperty.setParentProperty(parentProperty.getText());
		if (checkValid(childrenProperty))
			treeProperty.setChildrenProperty(childrenProperty.getText());
		//if (checkValid(classifyBy))
		//	treeProperty.setClassifyBy(classifyBy.getText());
 	  }
}
