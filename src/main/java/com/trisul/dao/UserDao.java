package com.trisul.dao;

import com.trisul.entity.IPEntity;
import com.trisul.entity.UserEntity;

public interface UserDao {

  UserEntity findByUsername(String username);

  UserEntity findByEmail(String email);

  UserEntity save(UserEntity userEntity);

  void saveTrackedRequest(IPEntity ipEntity);
}
