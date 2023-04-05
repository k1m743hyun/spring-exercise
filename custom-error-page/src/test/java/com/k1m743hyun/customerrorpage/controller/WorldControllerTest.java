package com.k1m743hyun.customerrorpage.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WorldController.class)
class WorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void printWorldGetIsOk() throws Exception {

        mockMvc.perform(get("/world"))
            .andExpect(status().isOk());
    }
}