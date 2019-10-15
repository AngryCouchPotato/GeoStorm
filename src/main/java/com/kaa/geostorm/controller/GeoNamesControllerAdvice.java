package com.kaa.geostorm.controller;

import com.kaa.geostorm.exception.CanNotGetDataException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@ControllerAdvice
@RequestMapping(produces = "application/json")
public class GeoNamesControllerAdvice {

    @ExceptionHandler(CanNotGetDataException.class)
    public ResponseEntity<VndErrors> canNotGetDataException(final CanNotGetDataException e) {
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<VndErrors> error(
            final Exception exception, final HttpStatus httpStatus) {
        final String message =
                Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(null, message), httpStatus);
    }
}
