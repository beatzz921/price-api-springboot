package com.priceapi.acceptance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PriceRequestDTO {

    @Getter
    @Setter
    private Long productId;

    @Getter
    @Setter
    private Long brandId;

    @Getter
    @Setter
    private String date;


}
