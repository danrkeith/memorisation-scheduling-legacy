package v3;

import tools.jackson.databind.ObjectMapper;
import v3.model.MemorisationSpec;

import java.io.IOException;
import java.io.InputStream;

public class InputReader {
    private static final String PLAN_FILENAME = "memorisation_spec_v3.json";

    public static MemorisationSpec read() {
        try (InputStream inputStream = InputReader.class.getClassLoader().getResourceAsStream(PLAN_FILENAME)) {
            if (inputStream == null) {
                throw new RuntimeException("Resource not found: " + PLAN_FILENAME);
            }

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, MemorisationSpec.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
