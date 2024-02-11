package com.priceapi.v1.exceptionhandler;

import com.priceapi.exception.ActivePriceNotFoundException;
import com.priceapi.exception.ApplicationExceptionCode;
import com.priceapi.v1.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class PriceControllerExceptionHandler {

    private static final String MESSAGE = "{} code: {}, detail: {} ";

    @ExceptionHandler(value = {ActivePriceNotFoundException.class})
    public ResponseEntity<Object> handleActivePriceNotFoundException(final ActivePriceNotFoundException ex) {
        log.error(MESSAGE, "method='handleActivePriceNotFoundException'", ex.getCode(), ex.getMessage());
        return this.getErrorResponse(ApplicationExceptionCode.ACTIVE_PRICE_NOT_FOUND, HttpStatus.NOT_FOUND, ex.getMessage());
    }

    private ResponseEntity<Object> getErrorResponse(final ApplicationExceptionCode errorCode, final HttpStatus httpStatus, final String message) {
        return new ResponseEntity<>(this.createErrorDTO(errorCode, message, httpStatus), httpStatus);
    }

    private ErrorDTO createErrorDTO(final ApplicationExceptionCode errorCode, final String message, final HttpStatus httpStatus) {
        final ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(String.valueOf(errorCode.getCode()));
        errorDTO.setTitle(httpStatus.toString());
        errorDTO.setDetail(message);
        return errorDTO;
    }

}
