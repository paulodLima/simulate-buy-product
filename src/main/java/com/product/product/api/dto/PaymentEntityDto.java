package com.product.product.api.dto;

import com.product.product.api.model.PaymentEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * A DTO for the {@link PaymentEntity} entity
 */
@Data
public class PaymentEntityDto{
    private Long id;
    private BigDecimal entry;
    private Integer installments;

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getEntry() {
        return entry;
    }

    public void setEntry(BigDecimal entry) {
        this.entry = entry;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}