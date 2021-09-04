package com.trisul.mapper;

import com.trisul.entity.MenuEntity;
import com.trisul.model.MenuDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper {

  MenuEntity convertMenuDetailToMenuEntity(MenuDetail md);

  MenuDetail convertMenuEntityToMenuDetail(MenuEntity me);
}
