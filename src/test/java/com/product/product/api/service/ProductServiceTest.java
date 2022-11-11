package com.product.product.api.service;

import com.product.product.api.dto.InstallmentListDto;
import com.product.product.api.dto.InstallmentsDefinitionDto;
import com.product.product.api.dto.PaymentEntityDto;
import com.product.product.api.dto.ProductEntityDto;
import com.product.product.api.mapper.ProductMapper;
import com.product.product.api.model.PaymentEntity;
import com.product.product.api.model.ProductEntity;
import com.product.product.api.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void simulateBuyProduct() {
        InstallmentsDefinitionDto definitionDto = spy(InstallmentsDefinitionDto.class);
        definitionDto.setPrice(BigDecimal.valueOf(999));
        definitionDto.setTax(BigDecimal.ONE);
        definitionDto.setInstallmentsNum(3);

        Map<Integer, BigDecimal> parcelas = new HashMap<>();
        parcelas.put(1,BigDecimal.valueOf(333));
        parcelas.put(2,BigDecimal.valueOf(333));
        parcelas.put(3,BigDecimal.valueOf(333));

        InstallmentListDto dto = new InstallmentListDto();
        dto.setInstallmentTax(parcelas);

        InstallmentListDto installmentListDto = productService.simulateBuyProduct(definitionDto);

        assertEquals(dto.getInstallmentTax() ,installmentListDto.getInstallmentTax());
    }
}