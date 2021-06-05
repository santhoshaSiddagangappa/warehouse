package com.warehouse.controller;

import com.warehouse.entity.Article;
import com.warehouse.service.WarehouseService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WarehouseController {

    @MockBean
    WarehouseService articleService;

    @Autowired
    private MockMvc mockMvc;

    @Ignore
    public void list() throws Exception {

        Article article = Article.builder()
                .id(10L)
                .name("Article")
                .stock(3)
                .build();

        given(articleService.loadArticles(any())).willReturn(Collections.singletonList(article));

        mockMvc.perform(get("/articles")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(10)))
                .andExpect(jsonPath("$[0].name", is("Article")))
                .andExpect(jsonPath("$[0].stock", is(3)));
    }

    @Test
    public void importJson() throws Exception {
//        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain", "Invalid Article".getBytes());
//
//        mockMvc.perform(multipart("/inventory/import").file(multipartFile)).andExpect(status().isBadRequest());
    }
}
