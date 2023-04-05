package com.k1m743hyun.customerrorpage.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CustomErrorController.class)
class CustomErrorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void handleErrorGetNotFound() throws Exception {

        mockMvc.perform(get("/hello"))
            .andExpect(status().is4xxClientError());
    }

    @Test
    void handleErrorGetBadRequest() throws Exception {

        mockMvc.perform(get("/error"))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType("application/json"));
    }

    @Test
    void handleErrorPostNotFound() throws Exception {

        mockMvc.perform(post("/hello"))
            .andExpect(status().is4xxClientError());
    }

    @Test
    void handleErrorPostBadRequest() throws Exception {

        mockMvc.perform(post("/error"))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType("application/json"));
    }

    @Test
    void handleErrorPutNotFound() throws Exception {

        mockMvc.perform(put("/hello"))
            .andExpect(status().is4xxClientError());
    }

    @Test
    void handleErrorPutBadRequest() throws Exception {

        mockMvc.perform(put("/error"))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType("application/json"));
    }

    @Test
    void handleErrorPatchNotFound() throws Exception {

        mockMvc.perform(patch("/hello"))
            .andExpect(status().is4xxClientError());
    }

    @Test
    void handleErrorPatchBadRequest() throws Exception {

        mockMvc.perform(patch("/error"))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType("application/json"));
    }

    @Test
    void handleErrorDeleteNotFound() throws Exception {

        mockMvc.perform(delete("/hello"))
            .andExpect(status().is4xxClientError());
    }

    @Test
    void handleErrorDeleteBadRequest() throws Exception {

        mockMvc.perform(delete("/error"))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType("application/json"));
    }

    @Test
    void handleErrorHeadNotFound() throws Exception {

        mockMvc.perform(head("/hello"))
            .andExpect(status().is4xxClientError());
    }

    @Test
    void handleErrorHeadBadRequest() throws Exception {

        mockMvc.perform(head("/error"))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType("application/json"));
    }

    @Test
    void handleErrorOptions() throws Exception {

        mockMvc.perform(options("/error"))
            .andExpect(status().isOk());
    }
}