package sage.springcoder.jamhubservice.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
public class JamDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        JamDto dto = getDto();
        String jsonString = objectMapper.writeValueAsString(dto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserializeDto() throws JsonProcessingException {
//        String jsonString = "{\"jamId\":\"c0a49620-a4c8-4a18-9ee7-bef9d2a0f5bf\",\"version\":null,\"createdDate\":\"2023-07-19T22:42:37.733693+05:30\"," +
//                "\"lastModifiedDate\":\"2023-07-19T22:42:37.733803+05:30\",\"jamName\":\"" +
//                "Strwaberry Bliss\",\"jamFlavor\":\"Strawberry_Delight\",\"upc\":100677654," +
//                "\"jamPrice\":145.72,\"quantityOnHand\":null}\n";
        String jsonString = "{\"jamId\":\"140e7c43-969f-454c-8c64-811f86929807\",\"version\":null,\"createdDate\":\"2023-07-19T23:+0530\",\"lastModifiedDate\":\"2023-07-19T23:16:11.63004+05:30\",\"jamName\":\"Strwaberry Bliss\",\"jamFlavor\":\"Strawberry_Delight\",\"upc\":100677654,\"quantityOnHand\":null,\"myLocalDate\":\"20230719\",\"jamPrice\":\"145.72\"}\n";
        JamDto dto = objectMapper.readValue(jsonString,JamDto.class);
        System.out.println(dto);
    }
}
