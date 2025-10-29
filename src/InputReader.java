import tools.jackson.databind.ObjectMapper;
import v1.MemorisationSpec;

import java.io.IOException;
import java.io.InputStream;

public class InputReader {
    private static final String PLAN_FILENAME = "plan.json";

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
