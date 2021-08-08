package com.trisul.entity;

import com.trisul.model.RoleTypeEnum;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import lombok.*;

/**
 * @author h3kumar
 * @since 27/03/2021
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "USER_ROLE_ENTITY")
public class UserRoleEntity {

  @Id
  @SequenceGenerator(
      name = "USER_ROLE_ENTITY_SEQ",
      sequenceName = "USER_ROLE_ENTITY_SEQ",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLE_ENTITY_SEQ")
  @Column(name = "USER_ROLE_ID", insertable = false, updatable = false)
  private Long id;

  @ManyToMany(mappedBy = "userRoles")
  private Set<UserEntity> users;

  @Enumerated(EnumType.STRING)
  @Column(name = "USER_ROLE_NAME", nullable = false)
  private RoleTypeEnum name;

  @Column(name = "USER_ROLE_DESCRIPTION", nullable = false)
  private String description;

  @Column(name = "USER_ROLE_CREATED_BY", nullable = false)
  private String createdBy = "ENGINE";

  @Column(name = "USER_ROLE_UPDATED_BY", nullable = false)
  private String updatedBy = "ENGINE";

  @Column(name = "USER_ROLE_CREATED_DATE_TIME", nullable = false)
  private Date createdDateTime;

  @Column(name = "USER_ROLE_MODIFIED_DATE_TIME", nullable = false)
  private Date modifiedDateTime;
}
