package com.product.product.api.controller;

import com.product.product.api.dto.SelicDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
class SelicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private SelicController selicController;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(selicController).build();
    }

    @Test
    void getRate() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/rate")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


    }

}