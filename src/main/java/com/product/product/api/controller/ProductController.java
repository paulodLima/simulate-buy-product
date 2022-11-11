package com.product.product.api.controller;

import com.product.product.api.dto.InstallmentListDto;
import com.product.product.api.dto.InstallmentsDefinitionDto;
import com.product.product.api.service.ProductService;
import com.product.product.api.dto.ProductEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public List<ProductEntityDto> getProducts(){
        return service.getAllProduct();
    }


    @PostMapping()
    public ProductEntityDto insertProduct(@RequestBody ProductEntityDto productEntityDto){
        return service.createProduct(productEntityDto);
    }

    @PostMapping("/simulate")
    public InstallmentListDto simulateBuyProduct(@RequestBody InstallmentsDefinitionDto installmentsDefinitionDto){
        return service.simulateBuyProduct(installmentsDefinitionDto);
    }
}
