package com.priceapi.mapper;

import com.priceapi.entity.PriceEntity;
import com.priceapi.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PriceEntityMapper {
    Price asPrice(PriceEntity price);

}
