package com.product.product.api.service;

import com.product.product.api.dto.InstallmentListDto;
import com.product.product.api.dto.InstallmentsDefinitionDto;
import com.product.product.api.dto.ProductEntityDto;
import com.product.product.api.dto.SelicDto;
import com.product.product.api.mapper.ProductMapper;
import com.product.product.api.model.ProductEntity;
import com.product.product.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private static final RestTemplate selic = new RestTemplate();

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private SelicService selicService;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public List<ProductEntityDto> getAllProduct(){

       return repository.findAll().stream().map(mapper::productEntityToProductEntityDto).collect(Collectors.toList());

    }

    public ProductEntityDto createProduct(ProductEntityDto productEntityDto) {

        ProductEntity productEntity =  repository.save(mapper.productEntityDtoToProductEntity(productEntityDto));

        return mapper.productEntityToProductEntityDto(productEntity);
    }

    public InstallmentListDto simulateBuyProduct(InstallmentsDefinitionDto dto) {

            return calculateTax(dto);

    }

    private InstallmentListDto calculateTax(InstallmentsDefinitionDto dto) {
        InstallmentListDto installmentListDto = new InstallmentListDto();
        Map<Integer, BigDecimal> parcelas = new HashMap<>();

        if(dto.getInstallmentsNum() >= 6){
            BigDecimal tax = taxSelic();
            dto.setTax(dto.getTax().multiply(tax).add(dto.getTax()));
            dto.setPrice(dto.getPrice().multiply(tax).add(dto.getPrice()));
        }
        for (Integer i = 1; i <= dto.getInstallmentsNum(); i++){
            parcelas.put(i, dto.getPrice().divide(BigDecimal.valueOf(dto.getInstallmentsNum()), RoundingMode.HALF_UP));
        }
        installmentListDto.setInstallmentTax(parcelas);

        return installmentListDto;
    }

    private BigDecimal taxSelic() {
        List<SelicDto> txs = selicService.getRateSelic(selic);

        return txs.stream().findFirst().get().getValue();
    }
}
