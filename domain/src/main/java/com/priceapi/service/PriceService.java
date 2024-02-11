package com.priceapi.service;

import com.priceapi.model.Price;
import org.springframework.stereotype.Component;

@Component
public interface PriceService {

    Price getActivePrice(Long productId, Long brandId, String date);
}
