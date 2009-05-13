package org.swingbean.plugin.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.swingbean.plugin.model.Descriptor;
import org.swingbean.plugin.model.Line;
import org.swingbean.plugin.model.Property;
import org.swingbean.plugin.model.PropertyType;

public class GeneratorTest {

	@Test
	public void testXmlGenerator() throws JAXBException, IOException{

		Descriptor descriptor = new Descriptor();
		Line line = new Line();
		Property property = new Property("nome1", PropertyType.BOOLEAN);
		property.setAttribute("teste2", "sdfsd");
		line.addProperty(property);
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
	
	private void createSchema(Descriptor descriptor) throws JAXBException, IOException{
		// specify where the generated XML schema will be created
		final File dir = new File("test/org/swingbean/plugin/test");

		// create a JAXBContext for the PrintOrder class
		JAXBContext ctx = JAXBContext.newInstance(Descriptor.class);
		// generate an XML schema from the annotated Descriptor model; create it
		// in the dir specified earlier under the default name, schema1.xsd
		ctx.generateSchema(new SchemaOutputResolver() {
			@Override
			public Result createOutput(String namespaceUri, String schemaName) throws IOException {
				return new StreamResult(new File(dir, schemaName));
			}
		});

	}
	
	

}
