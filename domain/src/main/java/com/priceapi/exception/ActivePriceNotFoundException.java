package com.priceapi.exception;

public class ActivePriceNotFoundException extends ApplicationException {

    public ActivePriceNotFoundException(final Long productId, final Long brandId, final String date) {
        super(ApplicationExceptionCode.ACTIVE_PRICE_NOT_FOUND.getCode(),
                String.format("Price with product Id: '%s', brand id: %s and date: %s not found", productId, brandId, date));
    }

}
