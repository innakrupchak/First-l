package InputOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import flate.*;
public class FlateXML implements IO<Flate> {

	@Override
	public void serialize(Flate obj, String title) throws IOException {
		File file = new File(title);
		String xmlString = "";
		try {
			JAXBContext context = JAXBContext.newInstance(Flate.class);
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

			StringWriter sw = new StringWriter();
			m.marshal(obj, sw);
			xmlString = sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		FileWriter fw = new FileWriter(file);
		fw.write(xmlString);
		fw.close();
	}

	@Override
	public Flate deserialize(String title) throws IOException {
		
		Flate e = null;
		try {

			File file = new File(title);
			JAXBContext jaxbContext = JAXBContext.newInstance(Flate.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			e = (Flate) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException err) {
			err.printStackTrace();
		}

		return e;

	}


}