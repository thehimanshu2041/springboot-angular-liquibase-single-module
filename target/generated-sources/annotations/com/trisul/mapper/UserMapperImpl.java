package com.trisul.mapper;

import com.trisul.entity.UserEntity;
import com.trisul.model.UserDetail;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-01T22:26:02+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (AdoptOpenJDK)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity convertUserDetailToUserEntity(UserDetail ud) {
        if ( ud == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( ud.getUsername() );
        userEntity.setEmail( ud.getEmail() );
        userEntity.setPassword( ud.getPassword() );
        userEntity.setTitle( ud.getTitle() );
        userEntity.setFirstName( ud.getFirstName() );
        userEntity.setLastName( ud.getLastName() );
        userEntity.setGender( ud.getGender() );
        userEntity.setDob( ud.getDob() );
        userEntity.setMobile( ud.getMobile() );

        return userEntity;
    }

    @Override
    public UserDetail convertUserEntityToUserDetail(UserEntity ue) {
        if ( ue == null ) {
            return null;
        }

        UserDetail userDetail = new UserDetail();

        userDetail.setUsername( ue.getUsername() );
        userDetail.setEmail( ue.getEmail() );
        userDetail.setPassword( ue.getPassword() );
        userDetail.setTitle( ue.getTitle() );
        userDetail.setFirstName( ue.getFirstName() );
        userDetail.setLastName( ue.getLastName() );
        userDetail.setGender( ue.getGender() );
        userDetail.setDob( ue.getDob() );
        userDetail.setMobile( ue.getMobile() );

        return userDetail;
    }
}
