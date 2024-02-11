package com.priceapi.v1.controller;

import com.priceapi.model.Price;
import com.priceapi.service.PriceService;
import com.priceapi.v1.api.PriceApi;
import com.priceapi.v1.dto.ActivePriceDTO;
import com.priceapi.v1.mapper.PriceMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@AllArgsConstructor
public class PriceController implements PriceApi {

    private final PriceService priceService;

    private final PriceMapper priceMapper;

    @Override
    public ResponseEntity<ActivePriceDTO> activePrice(Long productId,
                                                   Long brandId,
                                                   OffsetDateTime date) {
        Price activePrice = priceService.getActivePrice(productId, brandId, date.toString());

        return ResponseEntity.status(HttpStatus.OK).body(priceMapper.asPrice(activePrice));
    }
}
