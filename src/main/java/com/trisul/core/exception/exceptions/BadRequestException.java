package com.trisul.core.exception.exceptions;

import com.trisul.core.exception.FaultCode;
import com.trisul.core.factory.MessageResource;

public class BadRequestException extends ExceptionResolver {

  private static final long serialVersionUID = 1L;

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException(Exception exception) {
    super(exception);
  }

  public BadRequestException(FaultCode faultCode, Object... messageArguments) {
    super(MessageResource.getMessage(faultCode));
  }
}
