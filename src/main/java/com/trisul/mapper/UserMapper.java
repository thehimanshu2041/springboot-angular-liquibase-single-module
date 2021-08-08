package com.trisul.mapper;

import com.trisul.entity.UserEntity;
import com.trisul.model.UserDetail;
import org.mapstruct.Mapper;

/**
 * @author h3kumar
 * @since 16/05/2021
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

  UserEntity convertUserDetailToUserEntity(UserDetail ud);

  UserDetail convertUserEntityToUserDetail(UserEntity ue);
}
