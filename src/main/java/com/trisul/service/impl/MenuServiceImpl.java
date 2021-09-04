package com.trisul.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.trisul.dao.MenuDao;
import com.trisul.entity.MenuEntity;
import com.trisul.mapper.MenuMapper;
import com.trisul.model.MenuDetail;
import com.trisul.service.MenuService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

  @Autowired MenuDao menuDao;

  @Autowired MenuMapper menuMapper;

  private static final Cache<Long, List<MenuDetail>> menuCacheBuilder =
      CacheBuilder.newBuilder().initialCapacity(10).expireAfterAccess(10, TimeUnit.MINUTES).build();

  @Override
  public List<MenuDetail> getMenuList() {
    List<MenuDetail> menuCache = menuCacheBuilder.getIfPresent(1000000001L);
    if (menuCache != null) {
      return menuCache;
    }
    menuCache = getMappedMenuList();
    menuCacheBuilder.put(1000000001L, menuCache);
    return menuCache;
  }

  @Override
  public Boolean createMenuDetail(MenuDetail menuDetail) {
    return null != menuDao.createMenuDetail(menuMapper.convertMenuDetailToMenuEntity(menuDetail));
  }

  private List<MenuDetail> getMappedMenuList() {
    List<MenuEntity> finalMenuEntities = new ArrayList<>();
    Map<Long, MenuEntity> mapTmp = new HashMap<>();
    List<MenuEntity> menuEntityList = menuDao.getMenuList();
    for (MenuEntity current : menuEntityList) {
      mapTmp.put(current.getMenuID(), current);
    }

    for (MenuEntity current : menuEntityList) {
      Long parentId = current.getMenuParentID();

      if (parentId != current.getMenuID()) {
        MenuEntity parent = mapTmp.get(parentId);
        if (parent != null) {
          current.setParent(parent);
          parent.addChild(current);
          mapTmp.put(parentId, parent);
          mapTmp.put(current.getMenuID(), current);
        }
      }
    }

    for (MenuEntity node : mapTmp.values()) {
      if (null == node.getParent()) {
        finalMenuEntities.add(node);
      }
    }

    return finalMenuEntities.stream()
        .map(m -> menuMapper.convertMenuEntityToMenuDetail(m))
        .collect(Collectors.toList());
  }
}
