package com.priceapi.v1.mapper;

import com.priceapi.model.Price;
import com.priceapi.v1.dto.ActivePriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.OffsetDateTime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PriceMapper {

    default OffsetDateTime mapStringToOffsetDateTime(String dateString) {
        return OffsetDateTime.parse(dateString);
    }

    @Mapping(source = "brand.id", target = "brandId")
    ActivePriceDTO asPrice(Price price);

}
