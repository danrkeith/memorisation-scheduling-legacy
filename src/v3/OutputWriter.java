package v3;

import tools.jackson.databind.ObjectMapper;
import v3.model.Plan;

import java.io.File;

public class OutputWriter {
    public static void write(Plan plan, String filename) {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File(filename);

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(file, plan);
    }
}
