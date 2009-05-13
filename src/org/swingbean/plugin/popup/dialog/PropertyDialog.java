package org.swingbean.plugin.popup.dialog;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.swingbean.plugin.model.Property;

public class PropertyDialog extends Dialog {

	protected Table table;
	
	protected Property property;
	
	protected Map<String,Text> fields = new TreeMap<String, Text>();
	
	protected boolean refresh = false;
	
	public boolean isRefresh(){
		return refresh;
	}

	
	protected PropertyDialog(Shell parentShell) {
		super(parentShell);
	}

	public PropertyDialog(Shell parentShell, Property property) {
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
	
	public int open(){
		refresh = false;
		return super.open();
	}
	
	/**
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		
	    // create the composite to hold the widgets
		Composite composite =  new Composite(parent, SWT.NULL);
		
	    // create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		int ncol = 3;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		// create table
		table = new Table(composite, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		GridData gd = new GridData(GridData.FILL_BOTH);
	    gd.horizontalSpan = ncol;
	    table.setLayoutData(gd);
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
	    String[] titles = {"Property       ", "Value           ", "         "};

	    for (String title: titles) {
	    	TableColumn column = new TableColumn(table, SWT.CENTER);
	    	column.setText(title);
	    	column.setWidth(100);
	    }

        createField("name", property.getName());
        createField("type", property.getType().name());
        
        for (String key: property.ketSetAttribute()){
        	createField(key);
        }

		Button button = new Button(composite, SWT.PUSH);
		button.setText("Add Attribute...");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		button.setLayoutData(gd);
		button.addSelectionListener(new AddListener());

		initWidgetValues();
		
		

		return composite;

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
		for (String key: property.ketSetAttribute()){
        	if (property.getAttribute(key) != null){
    			fields.get(key).setText(property.getAttribute(key).toString());
        	}        
        }
	}

	protected void fillProperty(){
		for (String key: fields.keySet()){
        	if (notEmpty(fields.get(key))){
    			property.setAttribute(key, fields.get(key).getText());
        	}        
        }
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

	protected void createField(String fieldName){
		createField(fieldName, null);
	}

	protected void createField(String fieldName, String value){
	    TableItem item = new TableItem(table, SWT.NULL);
        item.setText(0, fieldName);

        TableEditor editor = new TableEditor(table);
        Text fieldText = null;
        if (value != null){
        	fieldText = new Text(table, SWT.NONE | SWT.READ_ONLY);
        	fieldText.setText(value);
            editor.grabHorizontal = true;
            editor.setEditor(fieldText, item, 1);
        }else{
        	fieldText = new Text(table, SWT.NONE);
            fields.put(fieldName, fieldText);
            editor.grabHorizontal = true;
            editor.setEditor(fieldText, item, 1);

            editor = new TableEditor(table);
            Button button = new Button(table, SWT.TOGGLE);
            button.setText("Delete");
            editor.grabHorizontal = true;
            editor.minimumHeight = button.getSize().y;
            editor.minimumWidth = button.getSize().x;
            button.pack();
            editor.setEditor(button, item, 2);
    		button.addSelectionListener(new RemoveListener(fieldName));
        }
        

	}
	
	class RemoveListener implements SelectionListener{

		private String field;
		public RemoveListener(String field){
			this.field = field;
		}

		public void widgetDefaultSelected(SelectionEvent arg0) {
			widgetSelected(arg0);
		}

		public void widgetSelected(SelectionEvent arg0) {
			property.removeAttribute(field);
			fields.remove(field);
		    refresh = true;
		    okPressed();
		}
		
	}

	class AddListener implements SelectionListener{

		public void widgetDefaultSelected(SelectionEvent arg0) {
			widgetSelected(arg0);
		}

		public void widgetSelected(SelectionEvent arg0) {
			AttributeDialog dialog = new AttributeDialog(getShell(), property);
			 int reply = dialog.open();
			 if (reply == AttributeDialog.OK) {
			     property = dialog.getProperty();
			     refresh = true;
			     okPressed();
			 }
		}
	}


}
