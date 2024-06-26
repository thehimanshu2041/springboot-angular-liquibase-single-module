package com.trisul.dao.impl;

import com.trisul.dao.UserDao;
import com.trisul.entity.IPEntity;
import com.trisul.entity.UserEntity;
import com.trisul.repository.IPRepository;
import com.trisul.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {

  @Autowired UserRepository userRepository;

  @Autowired IPRepository ipRepository;

  @Override
  public UserEntity findByUsername(String username) {
    return userRepository.findByUsername(username).orElse(null);
  }

  @Override
  public UserEntity findByEmail(String email) {
    return userRepository.findByEmail(email).orElse(null);
  }

  @Override
  public UserEntity save(UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  @Override
  public void saveTrackedRequest(IPEntity ipEntity) {
    ipRepository.save(ipEntity);
  }
}
