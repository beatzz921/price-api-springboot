package com.priceapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Price
 */
@Data
@AllArgsConstructor
public class Price {

    private Long id;

    private Long productId;

    private Float price;

    private String currency = "EURO";

    private Brand brand;

    private Long priceListId;

    private BigDecimal priority;

    private String startDate;

    private String endDate;

}

