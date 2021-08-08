package com.trisul.core.exception.exceptions;

import com.trisul.core.exception.FaultCode;
import com.trisul.core.factory.MessageResource;

public class ConflictException extends ExceptionResolver {

  private static final long serialVersionUID = 1L;

  public ConflictException(String message) {
    super(message);
  }

  public ConflictException(Exception exception) {
    super(exception);
  }

  public ConflictException(FaultCode faultCode, Object... messageArguments) {
    super(MessageResource.getMessage(faultCode));
  }
}
