package com.priceapi.exception;

import lombok.Getter;

public class ApplicationException extends RuntimeException {
    @Getter
    private final int code;

    public ApplicationException(final int code, final String message) {
        super(message);
        this.code = code;
    }
}
