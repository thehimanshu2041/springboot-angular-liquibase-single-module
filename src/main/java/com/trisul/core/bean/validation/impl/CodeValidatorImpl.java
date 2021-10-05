package com.trisul.core.bean.validation.impl;

import com.trisul.core.bean.validation.CodeValidator;
import com.trisul.model.CodeDetail;
import com.trisul.service.StaticDataService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodeValidatorImpl implements ConstraintValidator<CodeValidator, CodeDetail> {

  @Autowired StaticDataService staticDataService;

  @Override
  public void initialize(CodeValidator constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(
      CodeDetail codeDetail, ConstraintValidatorContext constraintValidatorContext) {
    if (null != codeDetail.getCodeID()) {
      return null != staticDataService.getCodeByCodeId(codeDetail.getCodeID());
    }
    return staticDataService.getCodesByCodeType(codeDetail.getCodeType()).stream()
        .anyMatch(f -> f.getCodeKey().equals(codeDetail.getCodeKey()));
  }
}
