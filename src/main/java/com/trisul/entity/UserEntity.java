package com.trisul.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "USER_ENTITY")
public class UserEntity {

  @Id
  @SequenceGenerator(name = "USER_ENTITY_SEQ", sequenceName = "USER_ENTITY_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ENTITY_SEQ")
  @Column(name = "USER_ID", insertable = false, updatable = false)
  private Long id;

  @Column(name = "USER_NAME", nullable = false, unique = true)
  private String username;

  @Column(name = "USER_EMAIL", nullable = false, unique = true)
  private String email;

  @Column(name = "USER_PASSWORD", nullable = false)
  private String password;

  @Column(name = "USER_TITLE", nullable = false)
  private String title;

  @Column(name = "USER_FIRST_NAME", nullable = false)
  private String firstName;

  @Column(name = "USER_LAST_NAME", nullable = true)
  private String lastName;

  @Column(name = "USER_GENDER", nullable = false)
  private String gender;

  @Column(name = "USER_DOB", nullable = false)
  private Date dob;

  @Column(name = "USER_MOBILE", nullable = false)
  private String mobile;

  @Column(name = "USER_IS_DELETED", nullable = false, columnDefinition = "tinyint(1) default 0")
  private boolean deleted;

  @Column(name = "USER_CREATED_BY", nullable = false)
  private String createdBy = "ENGINE";

  @Column(name = "USER_UPDATED_BY", nullable = false)
  private String updatedBy = "ENGINE";

  @CreationTimestamp
  @Column(name = "USER_CREATED_DATE_TIME", nullable = false)
  private Date createdDateTime;

  @UpdateTimestamp
  @Column(name = "USER_MODIFIED_DATE_TIME", nullable = false)
  private Date modifiedDateTime;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "USER_ENTITY_USER_ROLE_ENTITY",
      joinColumns = @JoinColumn(name = "USER_ID"),
      inverseJoinColumns = @JoinColumn(name = "USER_ROLE_ID"))
  private Set<UserRoleEntity> userRoles;
}
