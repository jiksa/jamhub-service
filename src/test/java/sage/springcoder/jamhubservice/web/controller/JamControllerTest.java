package sage.springcoder.jamhubservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sage.springcoder.jamhubservice.web.entity.Jam;
import sage.springcoder.jamhubservice.web.model.JamDto;
import sage.springcoder.jamhubservice.web.model.JamFlavorEnum;
import sage.springcoder.jamhubservice.web.service.JamService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JamController.class)
class JamControllerTest {

    @MockBean
    private JamService jamService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private JamDto jamDto;

    @BeforeEach
    void setUp() {
        jamDto = new JamDto().builder()
        .jamName("Test name").jamFlavor("Test flavor")
        .build();
    }

    @Test
    void getJamById() throws Exception {
        UUID jamId = UUID.randomUUID();
        when(jamService.getJamById(jamId)).thenReturn(jamDto);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/jam" , UUID.randomUUID().toString())
//                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        // Perform the request and validate the response
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/jam/"+ jamId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        String responseJson = resultActions.andReturn().getResponse().getContentAsString();
        JamDto actualJamDto = objectMapper.readValue(responseJson, JamDto.class);

        assertEquals(jamDto, actualJamDto);
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