package sage.springcoder.jamhubservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sage.springcoder.jamhubservice.web.entity.Jam;
import sage.springcoder.jamhubservice.web.model.JamDto;
import sage.springcoder.jamhubservice.web.model.JamFlavorEnum;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JamController.class)
class JamControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getJamById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/jam/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewJam() throws Exception {
        JamDto jamDto = JamDto.builder().jamName("Test Jam").jamFlavor(JamFlavorEnum.Blueberry_Blast.toString()).build();
        String jamDtoJson = objectMapper.writeValueAsString(jamDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/jam")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jamDtoJson)).andExpect(status().isCreated());

    }

    @Test
    void updateJam() throws Exception {
        JamDto jamDto = JamDto.builder().jamName("Test Jam").jamFlavor(JamFlavorEnum.Blueberry_Blast.toString()).build();
        String jamDtoJson = objectMapper.writeValueAsString(jamDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/jam/"+UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jamDtoJson)).andExpect(status().isNoContent());

    }
}