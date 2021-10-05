package com.trisul.dao;

import com.trisul.entity.MenuEntity;
import java.util.List;

public interface MenuDao {

  List<MenuEntity> getMenuList(Boolean status);

  MenuEntity createMenuDetail(MenuEntity menuEntity);
}
