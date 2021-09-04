package com.trisul.dao;

import com.trisul.entity.MenuEntity;
import java.util.List;

public interface MenuDao {

  List<MenuEntity> getMenuList();

  MenuEntity createMenuDetail(MenuEntity menuEntity);
}
