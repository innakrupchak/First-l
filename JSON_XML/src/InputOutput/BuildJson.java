package InputOutput;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import flate.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BuildJson implements IO<Build> {

	@Override
	public void serialize(Build obj, String title) throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		// Convert object to JSON string and save into a file directly
		mapper.writeValue(new File( title), obj);

	}

	
	@Override
	public Build deserialize(String title) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		Build e = mapper.readValue(new File( title), Build.class);
		return e;

	}

	
}

