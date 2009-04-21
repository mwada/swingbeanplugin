package org.swingbean.plugin.popup.wizards;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.swingbean.plugin.model.Descriptor;
import org.swingbean.plugin.model.Line;
import org.swingbean.plugin.model.Property;
import org.swingbean.plugin.model.PropertyFactory;
import org.swingbean.plugin.model.PropertyType;
import org.swingbean.plugin.popup.dialog.PropertyDialog;
import org.swingbean.plugin.popup.dialog.PropertyDialogFactory;

public class SwingBeanPage extends WizardPage implements Listener {

	Table table;

	CCombo[] propertyType;
	CCombo[] propertyLine;
	CCombo[] propertyColumn;
	Button[] propertyEdit;

	Property[] properties;

	String[] names;
	String[] lines;

	public SwingBeanPage(ICompilationUnit selection) {
		super("Page1");
		setTitle("SwingBean Descriptor");
		setDescription("Select the parameters");
		createCombos(selection);
	}

	private void createCombos(ICompilationUnit cu) {
		try {
			IType type = null;
			IType[] allTypes;
			allTypes = cu.getAllTypes();

			for (int t = 0; t < allTypes.length; t++) {
				if (Flags.isPublic((allTypes[t].getFlags()))) {
					type = allTypes[t];
					break;
				}
			}

			IField[] fields = type.getFields();
			names = new String[fields.length];
			lines = new String[fields.length];

			propertyType = new CCombo[fields.length];
			propertyLine = new CCombo[fields.length];
			propertyColumn = new CCombo[fields.length];
			propertyEdit = new Button[fields.length];
			properties = new Property[fields.length];
			for (int i=0; i<fields.length; i++) {
				names[i] = fields[i].getElementName();
				lines[i] = Integer.toString(i+1);
		        properties[i] = PropertyFactory.getProperty(names[i], PropertyType.TEXT);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}



	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {

	    // create the composite to hold the widgets
		GridData gd;
		Composite composite =  new Composite(parent, SWT.NULL);

	    // create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		int ncol = 4;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		// create table
		table = new Table(composite, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
	    gd = new GridData(GridData.FILL_BOTH);
	    gd.horizontalSpan = 4;
	    table.setLayoutData(gd);
	    table.setHeaderVisible(true);

	    String[] titles = {"Property       ", "Type           ", "Line           ", "Column          ", "Edit           "};

	    for (String title: titles) {
	    	TableColumn column = new TableColumn(table, SWT.CENTER);
	    	column.setText(title);
	    	column.setWidth(300);
	    }

	    for (int i=0; i<names.length; i++) {
	    	TableItem item = new TableItem(table, SWT.NULL);
	        item.setText(0, names[i]);

	        TableEditor editor = new TableEditor(table);
	        propertyType[i] = new CCombo(table, SWT.BORDER | SWT.READ_ONLY);
	        propertyType[i].setItems(PropertyType.getStringArray());
			propertyType[i].setText(PropertyType.TEXT.name());
	        editor.grabHorizontal = true;
	        editor.setEditor(propertyType[i], item, 1);

	        editor = new TableEditor(table);
	        propertyLine[i] = new CCombo(table, SWT.NONE);
	        propertyLine[i].setItems(lines);
	        propertyLine[i].setText(lines[i]);
	        editor.grabHorizontal = true;
	        editor.setEditor(propertyLine[i], item, 2);

	        editor = new TableEditor(table);
	        propertyColumn[i] = new CCombo(table, SWT.NONE);
	        propertyColumn[i].setItems(lines);
	        propertyColumn[i].setText(lines[0]);
	        editor.grabHorizontal = true;
	        editor.setEditor(propertyColumn[i], item, 3);

	        editor = new TableEditor(table);
	        propertyEdit[i] = new Button(table, SWT.PUSH);
	        propertyEdit[i].setText("Edit...");
	        propertyEdit[i].computeSize(SWT.DEFAULT, table.getItemHeight()-20);
	        editor.grabHorizontal = true;
	        editor.minimumHeight = propertyEdit[i].getSize().y;
	        editor.minimumWidth = propertyEdit[i].getSize().x;
	        editor.setEditor(propertyEdit[i], item, 4);
	    }

	    for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
	        table.getColumn(loopIndex).pack();
	    }

	    table.setBounds(25, 25, 220, 200);

		addListeners();
		setControl(composite);
		setPageComplete(true);
		saveDataToModel();
	}

	private void addListeners() {
		for (int i=0; i<names.length; i++){
			propertyType[i].addListener(SWT.Selection, this);
			propertyLine[i].addListener(SWT.Selection, this);
			propertyColumn[i].addListener(SWT.Selection, this);
			propertyEdit[i].addListener(SWT.Selection, this);
		}
	}


	/**
	 * @see Listener#handleEvent(Event)
	 */
	public void handleEvent(Event event) {

		int i;
		for (i=0; i<names.length; i++){
			if (event.widget == propertyEdit[i]){
				if (i<propertyEdit.length){
					 PropertyDialog dialog = PropertyDialogFactory.getDialog(getShell(), properties[i]);
					 int reply = dialog.open();
					 if (reply == PropertyDialog.OK) {
					     table.redraw();
					     properties[i] = dialog.getProperty();
					 }
				}
				break;
			}else if (event.widget == propertyType[i]){
				properties[i] = PropertyFactory.getProperty(names[i], PropertyType.fromString(propertyType[i].getText()));
			}
		}
		saveDataToModel();
		getWizard().getContainer().updateButtons();
	}



	private void saveDataToModel() {
		SwingBeanWizard wizard = (SwingBeanWizard)getWizard();
		Descriptor descriptor = wizard.getDescriptor();
		Property[][] aux = new Property[properties.length][properties.length];
		for (int i=0; i<properties.length; i++){
			aux[Integer.parseInt(propertyLine[i].getText())-1][Integer.parseInt(propertyColumn[i].getText())-1] = properties[i];
		}
		descriptor.clearLines();
		for (int i=0; i<properties.length; i++){
			Line line = new Line();
			for (int j=0; j<properties.length; j++){
				if (aux[i][j]!=null)
					line.addProperty(aux[i][j]);
			}
			if (!line.getProperties().isEmpty()){
				descriptor.addLine(line);
			}
		}
		wizard.setDescriptor(descriptor);
	}



}

