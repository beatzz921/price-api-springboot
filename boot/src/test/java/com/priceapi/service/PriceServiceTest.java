package com.priceapi.service;

import com.priceapi.entity.PriceEntity;
import com.priceapi.exception.ActivePriceNotFoundException;
import com.priceapi.mapper.PriceEntityMapperImpl;
import com.priceapi.model.Brand;
import com.priceapi.model.Price;
import com.priceapi.repository.PriceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    private static final Long PRICE_ENTITY_ID = 1L;
    private static final Float PRICE_ENTITY_PRICE = 80.5F;
    private static final String PRICE_ENTITY_CURRENCY = "EURO";
    private static final BigDecimal PRICE_ENTITY_PRIORITY = BigDecimal.valueOf(1);
    private static final String PRICE_ENTITY_START_DATE = "2023-09-15T10:00:00+01:00";
    private static final String PRICE_ENTITY_END_DATE = "2023-09-21T23:00:00+01:00";
    private static final Long BRAND_ENTITY_ID = 1L;
    private static final String BRAND_ENTITY_NAME = "ZARA";
    private static final Long PRODUCT_ID = 1L;
    private static final Long PRICE_LIST_ID = 1L;
    @InjectMocks
    private PriceServiceImpl priceService;
    @Spy
    private PriceRepository priceRepository;
    @Spy
    private PriceEntityMapperImpl priceEntityMapper;

    @Test
    void given_BrandIdAndProductIdAndDate_when_getActivePrice_then_success() {

        Price price = this.generatePrice();

        when(this.priceRepository.findHighestPriorityPriceByProductBrandDate(any(), any(), any())).thenReturn(Optional.ofNullable(mock(PriceEntity.class)));

        when(this.priceEntityMapper.asPrice(any())).thenReturn(price);

        Price result = this.priceService.getActivePrice(BRAND_ENTITY_ID, PRODUCT_ID, PRICE_ENTITY_START_DATE);

        Assertions.assertThat(result).isEqualTo(price);
    }

    @Test
    void given_BrandIdAndProductIdAndDate_when_getActivePrice_then_throwActivePriceNotFoundException() {

        when(this.priceRepository.findHighestPriorityPriceByProductBrandDate(any(), any(), any())).thenThrow(mock(ActivePriceNotFoundException.class));

        Assertions.assertThatExceptionOfType(ActivePriceNotFoundException.class).isThrownBy(() -> this.priceService.getActivePrice(BRAND_ENTITY_ID, PRODUCT_ID, PRICE_ENTITY_START_DATE));
    }

    private Brand generateBrand() {
        Brand brand = new Brand();
        brand.setId(BRAND_ENTITY_ID);
        brand.setName(BRAND_ENTITY_NAME);

        return brand;
    }

    private Price generatePrice() {
        Brand brand = this.generateBrand();
        return new Price(PRICE_ENTITY_ID, PRODUCT_ID, PRICE_ENTITY_PRICE, PRICE_ENTITY_CURRENCY, brand, PRICE_LIST_ID, PRICE_ENTITY_PRIORITY, PRICE_ENTITY_START_DATE, PRICE_ENTITY_END_DATE);
    }
}
