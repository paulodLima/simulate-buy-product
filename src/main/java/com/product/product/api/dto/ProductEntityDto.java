package com.product.product.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductEntityDto{
    private Long id;
    private String name;
    private BigDecimal price;
    private PaymentEntityDto paymentEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PaymentEntityDto getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntityDto paymentEntity) {
        this.paymentEntity = paymentEntity;
    }
}