package com.trisul.service.impl;

import com.trisul.core.exception.FaultCodeCache;
import com.trisul.core.exception.exceptions.NotFoundException;
import com.trisul.core.exception.exceptions.ServiceException;
import com.trisul.core.security.jwt.JwtTokenUtil;
import com.trisul.dao.UserDao;
import com.trisul.dao.UserRoleDao;
import com.trisul.entity.UserEntity;
import com.trisul.entity.UserRoleEntity;
import com.trisul.mapper.UserMapper;
import com.trisul.model.AuthenticationDetail;
import com.trisul.model.LoginDetail;
import com.trisul.model.RoleTypeEnum;
import com.trisul.model.UserDetail;
import com.trisul.service.UserService;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @author h3kumar
 * @since 16/05/2021
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

  @Autowired UserDao userDao;

  @Autowired UserRoleDao userRoleDao;

  @Autowired JwtTokenUtil jwtTokenUtil;

  @Autowired UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) {
    UserEntity user = userDao.findByUsername(username);
    if (user == null) {
      throw new NotFoundException(FaultCodeCache.TS_0002);
    }
    Set<SimpleGrantedAuthority> grantedAuthorities = getAuthorities(user);
    return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
  }

  @Override
  public AuthenticationDetail doLogin(LoginDetail loginDetail) {
    UserEntity user = userDao.findByUsername(loginDetail.getUsername());
    if (null == user) {
      throw new NotFoundException(FaultCodeCache.TS_0002);
    }
    if (user.getUsername().equals(loginDetail.getUsername())
        && checkPassword(loginDetail.getPassword(), user.getPassword())) {
      return new AuthenticationDetail(
          jwtTokenUtil.generateToken(loginDetail.getUsername()), getUserRoles(user.getUserRoles()));
    }
    throw new ServiceException(FaultCodeCache.TS_0006);
  }

  @Override
  public boolean createUser(UserDetail userDetail) {
    if (null != userDao.findByUsername(userDetail.getUsername())) {
      throw new ServiceException(FaultCodeCache.TS_0003);
    }
    if (null != userDao.findByEmail(userDetail.getEmail())) {
      throw new ServiceException(FaultCodeCache.TS_0004);
    }
    UserEntity userEntity = userMapper.convertUserDetailToUserEntity(userDetail);
    userEntity.setPassword(BCrypt.hashpw(userDetail.getPassword(), BCrypt.gensalt()));
    userEntity.setUserRoles(
        userRoleDao.findAllByNames(Collections.singletonList(RoleTypeEnum.USER)));
    return null != userDao.save(userEntity);
  }

  private Set<SimpleGrantedAuthority> getAuthorities(UserEntity user) {
    Set<UserRoleEntity> roleByUserId = user.getUserRoles();
    return roleByUserId.stream()
        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().toString().toUpperCase()))
        .collect(Collectors.toSet());
  }

  private Set<String> getUserRoles(Set<UserRoleEntity> userRoleEntities) {
    Set<String> roles = new HashSet<>();
    userRoleEntities.stream()
        .map(m -> roles.add(m.getName().getCode()))
        .collect(Collectors.toList());
    return roles;
  }

  private static boolean checkPassword(String password_plaintext, String stored_hash) {
    boolean password_verified = false;
    if (null == stored_hash || !stored_hash.startsWith("$2a$")) {
      throw new ServiceException(FaultCodeCache.TS_0005);
    }
    password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
    return (password_verified);
  }
}
