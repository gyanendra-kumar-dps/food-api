package com.example.demo.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.demo.dto.ErrorResponse;
import java.time.ZonedDateTime;
import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class FoodExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
                                                               HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String errorDetails = String.format("Unacceptable JSON %s", exception.getMessage());

        if (exception.getCause() instanceof InvalidFormatException ifx && ifx.getTargetType() != null && ifx.getTargetType().isEnum()) {
            errorDetails = String.format("Invalid enum value: '%s' for the field: '%s'. The value must be one of: %s.",
                    ifx.getValue(), ifx.getPath().get(ifx.getPath().size() - 1).getFieldName(), Arrays.toString(ifx.getTargetType().getEnumConstants()));
        }
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(errorDetails)
                .timestamp(ZonedDateTime.now())
                .build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.putAll(headers);
        return handleExceptionInternal(exception, errorResponse, setContentType(httpHeaders), HttpStatus.BAD_REQUEST, request);
    }


    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error("Other Exception", ex);
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(value = {FoodApiException.class})
    protected ResponseEntity<ErrorResponse> handleApiException(FoodApiException ex) {
        log.error("Food Api Exception: {}", ex.getMessage());
        return buildErrorResponse(ex.getHttpStatus(), ex.getMessage());
    }

    private HttpHeaders setContentType(HttpHeaders headers) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatusCode status, String message) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .timestamp(ZonedDateTime.now())
                .status(status)
                .message(message)
                .build(), setContentType(new HttpHeaders()), status);
    }

}
