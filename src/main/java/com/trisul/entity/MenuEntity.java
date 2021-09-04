package com.trisul.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "MENU_ENTITY")
public class MenuEntity {
  @Id
  @SequenceGenerator(name = "MENU_ENTITY_SEQ", sequenceName = "MENU_ENTITY_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_ENTITY_SEQ")
  @Column(name = "MENU_ID", insertable = false, updatable = false)
  private Long menuID;

  @Column(name = "MENU_PARENT_ID")
  private Long menuParentID;

  @Column(name = "MENU_NAME", nullable = false)
  private String menuName;

  @Column(name = "MENU_PATH", nullable = false)
  private String menuPath;

  @Column(name = "MENU_DESCRIPTION", nullable = false)
  private String menuDescription;

  @Column(name = "MENU_ICON", nullable = false)
  private String menuIcon;

  @Column(name = "MENU_KEY", nullable = false, unique = true)
  private String menuKey;

  @Column(name = "MENU_ACTIVE", nullable = false)
  private Boolean menuIsActive = true;

  @Column(name = "MENU_IS_DELETED", nullable = false)
  private Boolean menuIsDeleted = false;

  @Column(name = "MENU_IS_ADMIN", nullable = false)
  private Boolean menuIsAdmin = false;

  @Column(name = "MENU_IS_VISIBLE", nullable = false)
  private Boolean menuIsVisible = true;

  @Column(name = "MENU_IS_AUTH_REQ", nullable = false)
  private Boolean menuIsAuthReq = false;

  @Column(name = "MENU_PRIORITY")
  private Long menuPriority;

  @Column(name = "MENU_CREATED_BY", nullable = false)
  private String createdBy = "ENGINE";

  @Column(name = "MENU_UPDATED_BY", nullable = false)
  private String updatedBy = "ENGINE";

  @CreationTimestamp
  @Column(name = "MENU_CREATED_DATE_TIME", nullable = false)
  private Date createdDateTime;

  @UpdateTimestamp
  @Column(name = "MENU_MODIFIED_DATE_TIME", nullable = false)
  private Date modifiedDateTime;

  @Transient private List<MenuEntity> children;

  @Transient private String name;

  @JsonIgnore @Transient private MenuEntity parent;

  public MenuEntity() {
    super();
    this.children = new ArrayList<>();
  }

  public void addChild(MenuEntity child) {
    if (!this.children.contains(child) && child != null) this.children.add(child);
  }
}
