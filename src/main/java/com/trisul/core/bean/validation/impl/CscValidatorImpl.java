package com.trisul.core.bean.validation.impl;

import com.trisul.core.bean.validation.CscValidator;
import com.trisul.model.CscDetail;
import com.trisul.model.CscTypeEnum;
import com.trisul.service.StaticDataService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CscValidatorImpl implements ConstraintValidator<CscValidator, CscDetail> {

  @Autowired StaticDataService staticDataService;

  @Override
  public void initialize(CscValidator constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(
      CscDetail cscDetail, ConstraintValidatorContext constraintValidatorContext) {
    if (null != cscDetail.getCscID()) {
      return checkById(cscDetail.getCscID(), cscDetail.getCscType());
    } else if (null != cscDetail.getCscKey() && null != cscDetail.getCscType()) {
      return checkByCode(cscDetail.getCscKey(), cscDetail.getCscType());
    } else {
      return false;
    }
  }

  private boolean checkById(Long id, CscTypeEnum cscTypeEnum) {
    if (cscTypeEnum.CITY.getCode().equals("CITY")) {
      return null != staticDataService.getCityByCityId(id);
    } else if (cscTypeEnum.STATE.getCode().equals("STATE")) {
      return null != staticDataService.getStateByStateId(id);
    } else {
      return null != staticDataService.getCountryByCountryId(id);
    }
  }

  private boolean checkByCode(String code, CscTypeEnum cscTypeEnum) {
    if (cscTypeEnum.getCode().equals("CITY")) {
      return null != staticDataService.getCityByCityKey(code);
    } else if (cscTypeEnum.getCode().equals("STATE")) {
      return null != staticDataService.getStateByStateKey(code);
    } else {
      return null != staticDataService.getCountryByCountryKey(code);
    }
  }
}
