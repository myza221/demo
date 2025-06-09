package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_getBookByAuthor() throws Exception {
        String author = "my";
        ResultActions result = mockMvc.perform(get("/api/books/{author}", author));
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void test_saveBook() throws Exception {
        String payload = "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"title\": \"title\",\n" +
                "  \"author\": \"my\",\n" +
                "  \"publishedDate\": \"2568-06-09\"\n" +
                "}";

        ResultActions result = mockMvc.perform(post("/api/books/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200));
    }

    @Test
    void test_saveBook_wrong_date() throws Exception {
        String payload = "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"title\": \"title\",\n" +
                "  \"author\": \"my\",\n" +
                "  \"publishedDate\": \"1000-06-09\"\n" +
                "}";

        ResultActions result = mockMvc.perform(post("/api/books/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(400));
    }
}
