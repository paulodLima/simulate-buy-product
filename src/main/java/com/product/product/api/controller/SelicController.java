package com.product.product.api.controller;

import com.product.product.api.dto.SelicDto;
import com.product.product.api.service.SelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/v1/api/selic")
public class SelicController {

    @Autowired
    private SelicService selicService;

    private static final RestTemplate selic = new RestTemplate();

    @GetMapping("/rate")
    private List<SelicDto> getRate(){
        return selicService.getRateSelic(selic);
    }
}
