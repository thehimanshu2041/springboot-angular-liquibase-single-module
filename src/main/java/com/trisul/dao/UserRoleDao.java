package com.trisul.dao;

import com.trisul.entity.UserRoleEntity;
import com.trisul.model.RoleTypeEnum;
import java.util.List;
import java.util.Set;

/**
 * @author h3kumar
 * @since 16/05/2021
 */
public interface UserRoleDao {

  Set<UserRoleEntity> findAllByNames(List<RoleTypeEnum> roles);
}
