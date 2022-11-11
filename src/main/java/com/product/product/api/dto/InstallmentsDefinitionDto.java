package com.product.product.api.dto;

import java.math.BigDecimal;
import java.util.Map;

public class InstallmentsDefinitionDto {

    private Integer installmentsNum;
    private BigDecimal price;
    private BigDecimal tax;

    public Integer getInstallmentsNum() {
        return installmentsNum;
    }

    public void setInstallmentsNum(Integer installmentsNum) {
        this.installmentsNum = installmentsNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

}
