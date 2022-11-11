package com.product.product.api.service;

import com.product.product.api.dto.SelicDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class SelicService {

    private final String url = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json&";
    private final String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


    public List<SelicDto> getRateSelic(RestTemplate restTemplate){
        return Arrays.asList(restTemplate.getForObject(addDateUrl(), SelicDto[].class));
    }

    private String addDateUrl() {
        return  url.concat("dataInicial="+date).concat("&dataFinal="+date);
    }
}
