package com.product.product.api.mapper;

import com.product.product.api.model.PaymentEntity;
import com.product.product.api.model.ProductEntity;
import com.product.product.api.dto.ProductEntityDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity productEntityDtoToProductEntity(ProductEntityDto productEntityDto);

    ProductEntityDto productEntityToProductEntityDto(ProductEntity productEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductEntity updateProductEntityFromProductEntityDto(ProductEntityDto productEntityDto, @MappingTarget ProductEntity productEntity);

    @Mapping(source = "paymentEntity",target = "paymentEntity")
    @Mapping(target = "id", ignore = true)
    ProductEntityDto toResponse (ProductEntity productEntity, PaymentEntity paymentEntity);
}
