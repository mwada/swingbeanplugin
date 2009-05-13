package org.swingbean.plugin.popup.wizards;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import net.sf.classmock.ClassMock;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.swingBean.descriptor.GenericFieldDescriptor;
import org.swingBean.descriptor.XMLDescriptorFactory;
import org.swingBean.gui.JBeanPanel;
import org.swingbean.plugin.model.Descriptor;
import org.swingbean.plugin.util.TypeUtil;

public class SwingBeanWizard extends Wizard implements INewWizard {

	private ICompilationUnit selection;

	private SwingBeanPage mainPage;

	private Descriptor descriptor;

	private boolean complete;

	public SwingBeanWizard() {
		super();
		descriptor = new Descriptor();
		complete = true;
	}

	public void addPages() {
		mainPage = new SwingBeanPage(selection);
		addPage(mainPage);
	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection structuredSelection) {
	    selection =  (ICompilationUnit)structuredSelection.getFirstElement();
	}

	public boolean canFinish() {
		return complete;
	}

	public boolean performFinish() {
		try {
			createForm(createXml());
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return true;
	}

	public Descriptor getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(Descriptor descriptor) {
		this.descriptor = descriptor;
	}


	public void setComplete(boolean complete) {
		this.complete = complete;
	}


	private File createXml() throws JAXBException, IOException, JavaModelException{
		
		String[] name = selection.getCorrespondingResource().getName().split("\\.");
		DirectoryDialog fileDialog = new DirectoryDialog(new Shell());
		String dir = fileDialog.open();

		String fileName = dir + "/" + name[0] + ".xml";
		
		File file = new File(fileName);

		// specify a name for the generated XML instance document
		OutputStream os = new FileOutputStream(file);

        // create a JAXBContext for the PrintOrder class
        JAXBContext ctx = JAXBContext.newInstance(Descriptor.class);

        // create a marshaller
        Marshaller marshaller = ctx.createMarshaller();

        // the property JAXB_FORMATTED_OUTPUT specifies whether or not the
        // marshalled XML data is formatted with linefeeds and indentation
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // marshall the data in the Java content tree
        // to the XML instance document niceVet.xml
        marshaller.marshal(descriptor, os);
	
        return file;
	}

	private void createForm(File file){
		try{
			Class beanClass = getBeanClass();
			
			GenericFieldDescriptor descriptor = XMLDescriptorFactory
	        .getFieldDescriptor(beanClass, file, "Form");
			final JBeanPanel panel = new JBeanPanel(beanClass, descriptor);


			JPanel panelButton = new JPanel();
			
			JFrame frame = new JFrame("Form");
			frame.setSize(1000, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BorderLayout());
			frame.getContentPane().add(panel, BorderLayout.NORTH);
			frame.getContentPane().add(panelButton, BorderLayout.SOUTH);

			frame.setVisible(true);
			
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	private Class getBeanClass() {
		Class c = null;
		try {
			
			IJavaProject javaProject = selection.getJavaProject();
			IType type = null;
			IType[] allTypes;
			allTypes = selection.getAllTypes();

			for (int t = 0; t < allTypes.length; t++) {
				if (Flags.isPublic((allTypes[t].getFlags()))) {
					type = allTypes[t];
					break;
				}
			}
			
			IField[] fields = type.getFields();
	
			ClassMock mock = new ClassMock("Mock");
			
			
			for (int i=0; i<fields.length; i++) {
				String attributeName = fields[i].getElementName();
				Class attributeClass = TypeUtil.getClassType(Signature.getSignatureSimpleName(fields[i].getTypeSignature()));
				try{
					mock.addProperty(attributeName, attributeClass);
				}catch (Exception e1){
					e1.printStackTrace();
				}
			}
			
			c =  mock.createClass();
			
		
		}catch(Throwable e){
			e.printStackTrace();
		} 

		return c;
	
	}

}


