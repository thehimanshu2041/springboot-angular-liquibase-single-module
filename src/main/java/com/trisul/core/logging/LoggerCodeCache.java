package com.trisul.core.logging;

import org.springframework.context.support.ResourceBundleMessageSource;

public enum LoggerCodeCache implements LoggerCode {
  TS_0001,
  TS_0002,
  TS_0003;

  private static final String BUNDLE_NAME = "i18n.message";

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
