package tests.DZ_10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Tag("demoqa")
public class JsonEventTest {
    private ClassLoader cl = JsonEventTest.class.getClassLoader();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testJsonParsing() throws IOException {
        try (InputStream inputStream = cl.getResourceAsStream("filetest/testEvent.json")) {
            ModelEvent modelEvent = objectMapper.readValue(inputStream, ModelEvent.class);

            assertEquals("1.0", modelEvent.getApiVersion());
            assertEquals(152, modelEvent.getCounterId());
            assertEquals(1661166243, modelEvent.getTimestamp());
            assertEquals("CustomScript", modelEvent.getChannelType());
            assertEquals("32249ecb-1ff9-4a75-aa31-44a634440b9e", modelEvent.getUserId());
            assertEquals("название события-бесполезное", modelEvent.getTitle());


            Map<String, Object> customparams = modelEvent.getCustomparams();
            assertEquals(2, customparams.size());

            List<String> liuCixinCustomparams = Arrays.asList("Цвет кнопки","Синий");
            assertEquals(liuCixinCustomparams, customparams.get("params"));

            assertEquals("STRING", customparams.get("type"));
        }
    }
}
