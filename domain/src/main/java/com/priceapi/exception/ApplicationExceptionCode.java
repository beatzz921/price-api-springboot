package com.priceapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationExceptionCode {

    ACTIVE_PRICE_NOT_FOUND(0);

    private final int code;

}
