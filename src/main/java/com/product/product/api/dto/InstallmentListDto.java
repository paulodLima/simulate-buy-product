package com.product.product.api.dto;

import java.math.BigDecimal;
import java.util.Map;

public class InstallmentListDto {

    private Map<Integer, BigDecimal> installmentTax;

    public Map<Integer, BigDecimal> getInstallmentTax() {
        return installmentTax;
    }

    public void setInstallmentTax(Map<Integer, BigDecimal> installmentTax) {
        this.installmentTax = installmentTax;
    }
}
