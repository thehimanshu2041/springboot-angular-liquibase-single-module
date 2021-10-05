package com.trisul.mapper;

import com.trisul.entity.CodeEntity;
import com.trisul.entity.CodeTypeEntity;
import com.trisul.model.CodeDetail;
import com.trisul.model.CodeTypeDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-04T21:31:03+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class CodeMapperImpl implements CodeMapper {

    @Override
    public CodeEntity convertCodeDetailToCodeEntity(CodeDetail cd) {
        if ( cd == null ) {
            return null;
        }

        CodeEntity codeEntity = new CodeEntity();

        codeEntity.setCodeID( cd.getCodeID() );
        codeEntity.setCodeKey( cd.getCodeKey() );
        codeEntity.setCodeShortDescription( cd.getCodeShortDescription() );
        codeEntity.setCodeDescription( cd.getCodeDescription() );
        codeEntity.setCodePriority( cd.getCodePriority() );

        return codeEntity;
    }

    @Override
    public CodeTypeEntity convertCodeTypeDetailToCodeTypeEntity(CodeTypeDetail ctd) {
        if ( ctd == null ) {
            return null;
        }

        CodeTypeEntity codeTypeEntity = new CodeTypeEntity();

        codeTypeEntity.setCodeTypeID( ctd.getCodeTypeID() );
        codeTypeEntity.setCodeTypeKey( ctd.getCodeTypeKey() );
        codeTypeEntity.setCodeTypeShortDescription( ctd.getCodeTypeShortDescription() );
        codeTypeEntity.setCodeTypeDescription( ctd.getCodeTypeDescription() );
        codeTypeEntity.setCodeTypePriority( ctd.getCodeTypePriority() );
        codeTypeEntity.setCodes( codeDetailListToCodeEntityList( ctd.getCodes() ) );

        return codeTypeEntity;
    }

    @Override
    public CodeDetail convertCodeEntityToCodeDetail(CodeEntity ce) {
        if ( ce == null ) {
            return null;
        }

        CodeDetail codeDetail = new CodeDetail();

        codeDetail.setCodeType( ceCodeTypeCodeTypeKey( ce ) );
        codeDetail.setCodeID( ce.getCodeID() );
        codeDetail.setCodeKey( ce.getCodeKey() );
        codeDetail.setCodeShortDescription( ce.getCodeShortDescription() );
        codeDetail.setCodeDescription( ce.getCodeDescription() );
        codeDetail.setCodePriority( ce.getCodePriority() );

        return codeDetail;
    }

    @Override
    public CodeTypeDetail convertCodeTypeEntityToCodeTypeDetail(CodeTypeEntity cte) {
        if ( cte == null ) {
            return null;
        }

        CodeTypeDetail codeTypeDetail = new CodeTypeDetail();

        codeTypeDetail.setCodeTypeID( cte.getCodeTypeID() );
        codeTypeDetail.setCodeTypeKey( cte.getCodeTypeKey() );
        codeTypeDetail.setCodeTypeShortDescription( cte.getCodeTypeShortDescription() );
        codeTypeDetail.setCodeTypeDescription( cte.getCodeTypeDescription() );
        codeTypeDetail.setCodeTypePriority( cte.getCodeTypePriority() );
        codeTypeDetail.setCodes( codeEntityListToCodeDetailList( cte.getCodes() ) );

        return codeTypeDetail;
    }

    protected List<CodeEntity> codeDetailListToCodeEntityList(List<CodeDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<CodeEntity> list1 = new ArrayList<CodeEntity>( list.size() );
        for ( CodeDetail codeDetail : list ) {
            list1.add( convertCodeDetailToCodeEntity( codeDetail ) );
        }

        return list1;
    }

    private String ceCodeTypeCodeTypeKey(CodeEntity codeEntity) {
        if ( codeEntity == null ) {
            return null;
        }
        CodeTypeEntity codeType = codeEntity.getCodeType();
        if ( codeType == null ) {
            return null;
        }
        String codeTypeKey = codeType.getCodeTypeKey();
        if ( codeTypeKey == null ) {
            return null;
        }
        return codeTypeKey;
    }

    protected List<CodeDetail> codeEntityListToCodeDetailList(List<CodeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CodeDetail> list1 = new ArrayList<CodeDetail>( list.size() );
        for ( CodeEntity codeEntity : list ) {
            list1.add( convertCodeEntityToCodeDetail( codeEntity ) );
        }

        return list1;
    }
}
