package com.product.product.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SelicDto {

    @JsonIgnoreProperties(ignoreUnknown = true)

    @JsonProperty("data")
    private String date;
    @JsonProperty("valor")
    private BigDecimal value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
