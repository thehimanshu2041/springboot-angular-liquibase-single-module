package com.trisul.mapper;

import com.trisul.entity.CityEntity;
import com.trisul.entity.CountryEntity;
import com.trisul.entity.StateEntity;
import com.trisul.model.CscDetail;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-04T21:31:02+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class CscMapperImpl implements CscMapper {

    @Override
    public CscDetail convertCountryEntityToCscDetail(CountryEntity ce) {
        if ( ce == null ) {
            return null;
        }

        CscDetail cscDetail = new CscDetail();

        cscDetail.setCscID( ce.getCountryID() );
        cscDetail.setCscDescription( ce.getCountryDescription() );
        cscDetail.setCscType( toCscCountryTypeEnum( ce.getCountryKey() ) );
        cscDetail.setCscCodeID( ce.getCountryPhoneCode() );
        cscDetail.setCscKey( ce.getCountryKey() );
        cscDetail.setCscShortDescription( ce.getCountryShortDescription() );
        cscDetail.setCscPriority( ce.getCountryPriority() );

        return cscDetail;
    }

    @Override
    public CscDetail convertStateEntityToCscDetail(StateEntity se) {
        if ( se == null ) {
            return null;
        }

        CscDetail cscDetail = new CscDetail();

        cscDetail.setCscID( se.getStateID() );
        cscDetail.setCscDescription( se.getStateDescription() );
        cscDetail.setCscType( toCscStateTypeEnum( se.getStateKey() ) );
        cscDetail.setCscCodeID( se.getStateCountryId() );
        cscDetail.setCscKey( se.getStateKey() );
        cscDetail.setCscShortDescription( se.getStateShortDescription() );
        cscDetail.setCscPriority( se.getStatePriority() );

        return cscDetail;
    }

    @Override
    public CscDetail convertCityEntityToCscDetail(CityEntity ce) {
        if ( ce == null ) {
            return null;
        }

        CscDetail cscDetail = new CscDetail();

        cscDetail.setCscID( ce.getCityID() );
        cscDetail.setCscDescription( ce.getCityDescription() );
        cscDetail.setCscType( toCscCityTypeEnum( ce.getCityKey() ) );
        cscDetail.setCscCodeID( ce.getCityStateId() );
        cscDetail.setCscKey( ce.getCityKey() );
        cscDetail.setCscShortDescription( ce.getCityShortDescription() );
        cscDetail.setCscPriority( ce.getCityPriority() );

        return cscDetail;
    }

    @Override
    public CountryEntity convertCscDetailToCountryEntity(CscDetail cd) {
        if ( cd == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setCountryPhoneCode( cd.getCscCodeID() );
        countryEntity.setCountryKey( cd.getCscKey() );
        countryEntity.setCountryDescription( cd.getCscDescription() );
        countryEntity.setCountryShortDescription( cd.getCscShortDescription() );
        countryEntity.setCountryPriority( cd.getCscPriority() );
        countryEntity.setCountryID( cd.getCscID() );

        return countryEntity;
    }

    @Override
    public StateEntity convertCscDetailToStateEntity(CscDetail cd) {
        if ( cd == null ) {
            return null;
        }

        StateEntity stateEntity = new StateEntity();

        stateEntity.setStateID( cd.getCscID() );
        stateEntity.setStateShortDescription( cd.getCscShortDescription() );
        stateEntity.setStatePriority( cd.getCscPriority() );
        stateEntity.setStateDescription( cd.getCscDescription() );
        stateEntity.setStateCountryId( cd.getCscCodeID() );
        stateEntity.setStateKey( cd.getCscKey() );

        return stateEntity;
    }

    @Override
    public CityEntity convertCscDetailToCityEntity(CscDetail cd) {
        if ( cd == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setCityShortDescription( cd.getCscShortDescription() );
        cityEntity.setCityKey( cd.getCscKey() );
        cityEntity.setCityStateId( cd.getCscCodeID() );
        cityEntity.setCityDescription( cd.getCscDescription() );
        cityEntity.setCityID( cd.getCscID() );
        cityEntity.setCityPriority( cd.getCscPriority() );

        return cityEntity;
    }
}
