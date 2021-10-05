package com.trisul.core.exception;

import org.springframework.context.support.ResourceBundleMessageSource;

public enum FaultCodeCache implements FaultCode {
  TS_0001,
  TS_0002,
  TS_0003,
  TS_0004,
  TS_0005,
  TS_0006,
  TS_0007;

  private static final String BUNDLE_NAME = "i18n.exception";

  @Override
  public String getKey() {
    return toString();
  }

  @Override
  public ResourceBundleMessageSource getBundle() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename(BUNDLE_NAME);
    return messageSource;
  }
}
