package com.trisul.dao.impl;

import com.trisul.core.security.jwt.RoleTypeEnum;
import com.trisul.dao.UserRoleDao;
import com.trisul.entity.UserRoleEntity;
import com.trisul.repository.UserRoleRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleDaoImpl implements UserRoleDao {

  @Autowired UserRoleRepository userRoleRepository;

  @Override
  public Set<UserRoleEntity> findAllByNames(List<RoleTypeEnum> roles) {
    return userRoleRepository.findAllByNameIn(roles);
  }
}
