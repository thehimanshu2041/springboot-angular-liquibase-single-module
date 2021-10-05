package com.trisul.mapper;

import com.trisul.entity.AddressEntity;
import com.trisul.entity.CardEntity;
import com.trisul.entity.CityEntity;
import com.trisul.entity.CodeEntity;
import com.trisul.entity.CountryEntity;
import com.trisul.entity.StateEntity;
import com.trisul.entity.UserEntity;
import com.trisul.model.AddressDetail;
import com.trisul.model.CardDetail;
import com.trisul.model.CodeDetail;
import com.trisul.model.CscDetail;
import com.trisul.model.UserDetail;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-04T21:31:02+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private CscMapper cscMapper;

    @Override
    public UserEntity convertUserDetailToUserEntity(UserDetail ud) {
        if ( ud == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setAddressEntity( addressDetailToAddressEntity( ud.getAddressDetail() ) );
        userEntity.setGender( udGenderCodeID( ud ) );
        userEntity.setTitle( udTitleCodeID( ud ) );
        userEntity.setCardEntity( cardDetailToCardEntity( ud.getCardDetail() ) );
        userEntity.setId( ud.getId() );
        userEntity.setUsername( ud.getUsername() );
        userEntity.setEmail( ud.getEmail() );
        userEntity.setPassword( ud.getPassword() );
        userEntity.setFirstName( ud.getFirstName() );
        userEntity.setLastName( ud.getLastName() );
        userEntity.setDob( ud.getDob() );
        userEntity.setMobile( ud.getMobile() );

        return userEntity;
    }

    @Override
    public UserDetail convertUserEntityToUserDetail(UserEntity ue, CodeEntity titleCode, CodeEntity genderCode, CityEntity cte, StateEntity ste, CountryEntity cne) {
        if ( ue == null && titleCode == null && genderCode == null && cte == null && ste == null && cne == null ) {
            return null;
        }

        UserDetail userDetail = new UserDetail();

        if ( ue != null ) {
            if ( ue.getAddressEntity() != null ) {
                if ( userDetail.getAddressDetail() == null ) {
                    userDetail.setAddressDetail( new AddressDetail() );
                }
                addressEntityToAddressDetail( ue.getAddressEntity(), userDetail.getAddressDetail() );
            }
            userDetail.setCardDetail( cardEntityToCardDetail( ue.getCardEntity() ) );
            userDetail.setId( ue.getId() );
            userDetail.setUsername( ue.getUsername() );
            userDetail.setEmail( ue.getEmail() );
            userDetail.setPassword( ue.getPassword() );
            userDetail.setFirstName( ue.getFirstName() );
            userDetail.setLastName( ue.getLastName() );
            userDetail.setDob( ue.getDob() );
            userDetail.setMobile( ue.getMobile() );
        }
        if ( titleCode != null ) {
            userDetail.setTitle( codeMapper.convertCodeEntityToCodeDetail( titleCode ) );
        }
        if ( genderCode != null ) {
            userDetail.setGender( codeMapper.convertCodeEntityToCodeDetail( genderCode ) );
        }
        if ( cte != null ) {
            if ( userDetail.getAddressDetail() == null ) {
                userDetail.setAddressDetail( new AddressDetail() );
            }
            cityEntityToAddressDetail( cte, userDetail.getAddressDetail() );
        }
        if ( ste != null ) {
            if ( userDetail.getAddressDetail() == null ) {
                userDetail.setAddressDetail( new AddressDetail() );
            }
            stateEntityToAddressDetail( ste, userDetail.getAddressDetail() );
        }
        if ( cne != null ) {
            if ( userDetail.getAddressDetail() == null ) {
                userDetail.setAddressDetail( new AddressDetail() );
            }
            countryEntityToAddressDetail( cne, userDetail.getAddressDetail() );
        }

        return userDetail;
    }

    private Long addressDetailAddressCityCscID(AddressDetail addressDetail) {
        if ( addressDetail == null ) {
            return null;
        }
        CscDetail addressCity = addressDetail.getAddressCity();
        if ( addressCity == null ) {
            return null;
        }
        Long cscID = addressCity.getCscID();
        if ( cscID == null ) {
            return null;
        }
        return cscID;
    }

    private Long addressDetailAddressStateCscID(AddressDetail addressDetail) {
        if ( addressDetail == null ) {
            return null;
        }
        CscDetail addressState = addressDetail.getAddressState();
        if ( addressState == null ) {
            return null;
        }
        Long cscID = addressState.getCscID();
        if ( cscID == null ) {
            return null;
        }
        return cscID;
    }

    private Long addressDetailAddressCountryCscID(AddressDetail addressDetail) {
        if ( addressDetail == null ) {
            return null;
        }
        CscDetail addressCountry = addressDetail.getAddressCountry();
        if ( addressCountry == null ) {
            return null;
        }
        Long cscID = addressCountry.getCscID();
        if ( cscID == null ) {
            return null;
        }
        return cscID;
    }

    protected AddressEntity addressDetailToAddressEntity(AddressDetail addressDetail) {
        if ( addressDetail == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setAddressCity( addressDetailAddressCityCscID( addressDetail ) );
        addressEntity.setAddressState( addressDetailAddressStateCscID( addressDetail ) );
        addressEntity.setAddressCountry( addressDetailAddressCountryCscID( addressDetail ) );
        addressEntity.setAddressID( addressDetail.getAddressID() );
        addressEntity.setAddressAddress1( addressDetail.getAddressAddress1() );
        addressEntity.setAddressAddress2( addressDetail.getAddressAddress2() );
        addressEntity.setAddressAddress3( addressDetail.getAddressAddress3() );

        return addressEntity;
    }

    private Long udGenderCodeID(UserDetail userDetail) {
        if ( userDetail == null ) {
            return null;
        }
        CodeDetail gender = userDetail.getGender();
        if ( gender == null ) {
            return null;
        }
        Long codeID = gender.getCodeID();
        if ( codeID == null ) {
            return null;
        }
        return codeID;
    }

    private Long udTitleCodeID(UserDetail userDetail) {
        if ( userDetail == null ) {
            return null;
        }
        CodeDetail title = userDetail.getTitle();
        if ( title == null ) {
            return null;
        }
        Long codeID = title.getCodeID();
        if ( codeID == null ) {
            return null;
        }
        return codeID;
    }

    protected CardEntity cardDetailToCardEntity(CardDetail cardDetail) {
        if ( cardDetail == null ) {
            return null;
        }

        CardEntity cardEntity = new CardEntity();

        cardEntity.setCardID( cardDetail.getCardID() );
        cardEntity.setCardNumber( cardDetail.getCardNumber() );
        cardEntity.setCardFirstName( cardDetail.getCardFirstName() );
        cardEntity.setCardLastName( cardDetail.getCardLastName() );
        cardEntity.setCardExpireMonth( cardDetail.getCardExpireMonth() );
        cardEntity.setCardExpireYear( cardDetail.getCardExpireYear() );
        cardEntity.setCardCvv( cardDetail.getCardCvv() );

        return cardEntity;
    }

    protected void addressEntityToAddressDetail(AddressEntity addressEntity, AddressDetail mappingTarget) {
        if ( addressEntity == null ) {
            return;
        }

        mappingTarget.setAddressAddress3( addressEntity.getAddressAddress3() );
        mappingTarget.setAddressAddress2( addressEntity.getAddressAddress2() );
        mappingTarget.setAddressAddress1( addressEntity.getAddressAddress1() );
        mappingTarget.setAddressID( addressEntity.getAddressID() );
    }

    protected void cityEntityToAddressDetail(CityEntity cityEntity, AddressDetail mappingTarget) {
        if ( cityEntity == null ) {
            return;
        }

        mappingTarget.setAddressCity( cscMapper.convertCityEntityToCscDetail( cityEntity ) );
    }

    protected void stateEntityToAddressDetail(StateEntity stateEntity, AddressDetail mappingTarget) {
        if ( stateEntity == null ) {
            return;
        }

        mappingTarget.setAddressState( cscMapper.convertStateEntityToCscDetail( stateEntity ) );
    }

    protected void countryEntityToAddressDetail(CountryEntity countryEntity, AddressDetail mappingTarget) {
        if ( countryEntity == null ) {
            return;
        }

        mappingTarget.setAddressCountry( cscMapper.convertCountryEntityToCscDetail( countryEntity ) );
    }

    protected CardDetail cardEntityToCardDetail(CardEntity cardEntity) {
        if ( cardEntity == null ) {
            return null;
        }

        CardDetail cardDetail = new CardDetail();

        cardDetail.setCardID( cardEntity.getCardID() );
        cardDetail.setCardNumber( cardEntity.getCardNumber() );
        cardDetail.setCardFirstName( cardEntity.getCardFirstName() );
        cardDetail.setCardLastName( cardEntity.getCardLastName() );
        cardDetail.setCardExpireMonth( cardEntity.getCardExpireMonth() );
        cardDetail.setCardExpireYear( cardEntity.getCardExpireYear() );
        cardDetail.setCardCvv( cardEntity.getCardCvv() );

        return cardDetail;
    }
}
