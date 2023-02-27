package com.aiceltech.devassignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
class DevAssignmentApplicationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void list() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.get("/api/test")
                        .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.get("/api/testParam").param("param", "paramTest")
                        .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void create() throws Exception {

        TestController.TestRequest testRequest = new TestController.TestRequest();
        testRequest.setId("testId");

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.post("/api/testBody").content(objectMapper.writeValueAsString(testRequest))
                        .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void update() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.put("/api/test")
                        .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void delete() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.delete("/api/test")
                        .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

}
