package org.swingbean.plugin.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.swingbean.plugin.model.ComboProperty;
import org.swingbean.plugin.model.Descriptor;
import org.swingbean.plugin.model.Line;
import org.swingbean.plugin.model.PropertyType;
import org.swingbean.plugin.model.TextProperty;


public class GeneratorTest {

	@Test
	public void testXmlGenerator() throws JAXBException, IOException{

		Descriptor descriptor = new Descriptor();
		Line line = new Line();
		TextProperty property = new TextProperty();
		property.setType(PropertyType.TEXT);
		property.setFormatExample("sdfsdf");
		property.setColspan(2);
		line.addProperty(property);

		ComboProperty property2 = new ComboProperty();
		property2.setName("teste");
		line.addProperty(property2);

		descriptor.addLine(line);

		createXml(descriptor);

	}

	private void createXml(Descriptor descriptor) throws JAXBException, IOException{
        // specify a name for the generated XML instance document
        OutputStream os = new FileOutputStream("test/swingbean.xml");

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
