package com.trisul.dao;

import com.trisul.entity.UserEntity;

/**
 * @author h3kumar
 * @since 16/05/2021
 */
public interface UserDao {

  UserEntity findByUsername(String username);

  UserEntity findByEmail(String email);

  UserEntity save(UserEntity userEntity);
}
