package com.trisul.service;

import com.trisul.model.MenuDetail;
import java.util.List;

public interface MenuService {

  List<MenuDetail> getMenuList();

  Boolean createMenuDetail(MenuDetail menuDetail);
}
