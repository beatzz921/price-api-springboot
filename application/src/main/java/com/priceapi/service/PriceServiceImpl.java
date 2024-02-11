package com.priceapi.service;

import com.priceapi.entity.PriceEntity;
import com.priceapi.exception.ActivePriceNotFoundException;
import com.priceapi.mapper.PriceEntityMapper;
import com.priceapi.model.Price;
import com.priceapi.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final PriceEntityMapper priceEntityMapper;

    @Override
    public Price getActivePrice(Long productId, Long brandId, String date) {

        /* we call the PriceRepository method to find the highest priority price given brandId, productId and date */
        PriceEntity priceEntity = this.priceRepository.findHighestPriorityPriceByProductBrandDate(productId, brandId, date)
                .orElseThrow(() -> new ActivePriceNotFoundException(productId, brandId, date));
        return this.priceEntityMapper.asPrice(priceEntity);
    }
}
