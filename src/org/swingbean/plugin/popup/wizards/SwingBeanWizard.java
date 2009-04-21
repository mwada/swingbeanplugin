package org.swingbean.plugin.popup.wizards;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.swingbean.plugin.model.Descriptor;

public class SwingBeanWizard extends Wizard implements INewWizard {

	private ICompilationUnit selection;

	private SwingBeanPage mainPage;

	private Descriptor descriptor;

	public SwingBeanWizard() {
		super();
		descriptor = new Descriptor();
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
		return true;
	}

	public boolean performFinish() {
		try {
			createXml();
			System.out.println("criado");
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

	private void createXml() throws JAXBException, IOException, JavaModelException{

		String[] name = selection.getCorrespondingResource().getName().split("\\.");
		DirectoryDialog fileDialog = new DirectoryDialog(new Shell());
		String dir = fileDialog.open();

		String fileName = dir + "/" + name[0] + ".xml";

		System.out.println(fileName);

		// specify a name for the generated XML instance document
        OutputStream os = new FileOutputStream(fileName);

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
	}

}
