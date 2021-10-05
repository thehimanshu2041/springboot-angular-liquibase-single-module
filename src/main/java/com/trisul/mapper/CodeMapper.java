package com.trisul.mapper;

import com.trisul.entity.CodeEntity;
import com.trisul.entity.CodeTypeEntity;
import com.trisul.model.CodeDetail;
import com.trisul.model.CodeTypeDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CodeMapper {

  /* @Mapping(target = "codeCreatedDateTime", ignore = true)
  @Mapping(target = "codeModifiedDateTime", ignore = true)*/
  @Mapping(target = "codeType", ignore = true)
  CodeEntity convertCodeDetailToCodeEntity(CodeDetail cd);

  /*@Mapping(target = "codeTypeCreatedDateTime", ignore = true)
  @Mapping(target = "codeTypeModifiedDateTime", ignore = true)*/
  CodeTypeEntity convertCodeTypeDetailToCodeTypeEntity(CodeTypeDetail ctd);

  @Mapping(source = "ce.codeType.codeTypeKey", target = "codeType")
  CodeDetail convertCodeEntityToCodeDetail(CodeEntity ce);

  CodeTypeDetail convertCodeTypeEntityToCodeTypeDetail(CodeTypeEntity cte);
}
