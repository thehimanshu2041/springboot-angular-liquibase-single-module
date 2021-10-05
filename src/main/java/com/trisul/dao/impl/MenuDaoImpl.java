package com.trisul.dao.impl;

import com.trisul.dao.MenuDao;
import com.trisul.entity.MenuEntity;
import com.trisul.repository.MenuRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDaoImpl implements MenuDao {

  @Autowired MenuRepository menuRepository;

  @Override
  public List<MenuEntity> getMenuList(Boolean status) {
    return menuRepository.findAllByMenuIsAuthReqOrderByMenuPriorityAsc(status);
  }

  @Override
  public MenuEntity createMenuDetail(MenuEntity menuEntity) {
    return menuRepository.save(menuEntity);
  }
}
