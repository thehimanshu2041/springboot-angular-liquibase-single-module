package com.trisul.core.exception;

import com.trisul.core.exception.exceptions.*;
import com.trisul.core.exception.model.Error;
import com.trisul.core.exception.model.ErrorMessage;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionsHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage notFoundExceptionHandler(NotFoundException ex, WebRequest request) {
    ErrorMessage message =
        new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            new Date(),
            new Error(ex.getMessage(), request.getDescription(false)));
    return message;
  }

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMessage badRequestExceptionHandler(BadRequestException ex, WebRequest request) {
    ErrorMessage message =
        new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            new Date(),
            new Error(ex.getMessage(), request.getDescription(false)));
    return message;
  }

  @ExceptionHandler(ConflictException.class)
  @ResponseStatus(value = HttpStatus.CONFLICT)
  public ErrorMessage conflictExceptionHandler(ConflictException ex, WebRequest request) {
    ErrorMessage message =
        new ErrorMessage(
            HttpStatus.CONFLICT.value(),
            new Date(),
            new Error(ex.getMessage(), request.getDescription(false)));
    return message;
  }

  @ExceptionHandler(UnAuthorisedException.class)
  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
  public ErrorMessage unAuthorisedExceptionHandler(UnAuthorisedException ex, WebRequest request) {
    ErrorMessage message =
        new ErrorMessage(
            HttpStatus.UNAUTHORIZED.value(),
            new Date(),
            new Error(ex.getMessage(), request.getDescription(false)));
    return message;
  }

  @ExceptionHandler(ServiceException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage serviceExceptionHandler(ServiceException ex, WebRequest request) {
    ErrorMessage message =
        new ErrorMessage(
            2041, new Date(), new Error(ex.getMessage(), request.getDescription(false)));
    return message;
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
    ErrorMessage message =
        new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            new Date(),
            new Error(ex.getMessage(), request.getDescription(false)));
    return message;
  }
}
