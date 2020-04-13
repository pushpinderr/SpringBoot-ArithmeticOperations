package com.springboot.arithemeticservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.arithemeticservice.bootstrap.SpringBootArithmeticOperationsApplication;
import com.springboot.arithemeticservice.domain.ArithmeticOperationsService;
import com.springboot.arithemeticservice.infrastructure.request.ArithmeticData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = SpringBootArithmeticOperationsApplication.class, webEnvironment = RANDOM_PORT)
public class ArithmeticOperationsApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ArithmeticOperationsService arithmeticOperationsService;

    @Test
    public void test_user_request_is_not_authenticated() throws Exception {
        mockMvc.perform(post("/api/add")
                .content(objectMapper.writeValueAsString(new ArithmeticData(100, 50)))
                .contentType("application/json"))
                .andExpect(unauthenticated());
    }

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void test_user_request_is_authenticated() throws Exception {
        mockMvc.perform(post("/api/add")
                .content(objectMapper.writeValueAsString(new ArithmeticData(100, 50)))
                .contentType("application/json"))
                .andExpect(authenticated())
                .andExpect(authenticated().withUsername("admin"))
                .andExpect(authenticated().withRoles("USER"));
    }

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void test_valid_addition_request() throws Exception {
        mockMvc.perform(post("/api/add")
                .content(objectMapper.writeValueAsString(new ArithmeticData(100, 50)))
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("150"));
    }

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void test_invalid_addition_request() throws Exception {
        mockMvc.perform(post("/api/add")
                .content("{\n" +
                        "    \"x\": \"abc\",\n" +
                        "    \"y\": 100\n" +
                        "}")
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void test_valid_subtraction_request() throws Exception {
        mockMvc.perform(post("/api/diff")
                .content(objectMapper.writeValueAsString(new ArithmeticData(100, 50)))
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("50"));
    }

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void test_invalid_subtraction_request() throws Exception {
        mockMvc.perform(post("/api/diff")
                .content("{\n" +
                        "    \"x\": \"abc\",\n" +
                        "    \"y\": 100\n" +
                        "}")
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }
}