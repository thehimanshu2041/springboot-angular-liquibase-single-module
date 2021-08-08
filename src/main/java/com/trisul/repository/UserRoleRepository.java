package com.trisul.repository;

import com.trisul.entity.UserRoleEntity;
import com.trisul.model.RoleTypeEnum;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author h3kumar
 * @since 28/03/2021
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

  Set<UserRoleEntity> findAllByNameIn(List<RoleTypeEnum> roles);
}
