package com.trisul.mapper;

import com.trisul.entity.MenuEntity;
import com.trisul.model.MenuDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-22T13:23:54+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class MenuMapperImpl implements MenuMapper {

    @Override
    public MenuEntity convertMenuDetailToMenuEntity(MenuDetail md) {
        if ( md == null ) {
            return null;
        }

        MenuEntity menuEntity = new MenuEntity();

        menuEntity.setMenuID( md.getMenuID() );
        menuEntity.setMenuParentID( md.getMenuParentID() );
        menuEntity.setMenuName( md.getMenuName() );
        menuEntity.setMenuPath( md.getMenuPath() );
        menuEntity.setMenuDescription( md.getMenuDescription() );
        menuEntity.setMenuIcon( md.getMenuIcon() );
        menuEntity.setMenuKey( md.getMenuKey() );
        menuEntity.setMenuIsActive( md.getMenuIsActive() );
        menuEntity.setMenuIsDeleted( md.getMenuIsDeleted() );
        menuEntity.setMenuIsAdmin( md.getMenuIsAdmin() );
        menuEntity.setMenuIsVisible( md.getMenuIsVisible() );
        menuEntity.setMenuIsAuthReq( md.getMenuIsAuthReq() );
        menuEntity.setMenuPriority( md.getMenuPriority() );
        menuEntity.setChildren( menuDetailListToMenuEntityList( md.getChildren() ) );

        return menuEntity;
    }

    @Override
    public MenuDetail convertMenuEntityToMenuDetail(MenuEntity me) {
        if ( me == null ) {
            return null;
        }

        MenuDetail menuDetail = new MenuDetail();

        menuDetail.setMenuID( me.getMenuID() );
        menuDetail.setMenuParentID( me.getMenuParentID() );
        menuDetail.setMenuName( me.getMenuName() );
        menuDetail.setMenuPath( me.getMenuPath() );
        menuDetail.setMenuDescription( me.getMenuDescription() );
        menuDetail.setMenuIcon( me.getMenuIcon() );
        menuDetail.setMenuKey( me.getMenuKey() );
        menuDetail.setMenuIsActive( me.getMenuIsActive() );
        menuDetail.setMenuIsDeleted( me.getMenuIsDeleted() );
        menuDetail.setMenuIsAdmin( me.getMenuIsAdmin() );
        menuDetail.setMenuIsVisible( me.getMenuIsVisible() );
        menuDetail.setMenuIsAuthReq( me.getMenuIsAuthReq() );
        menuDetail.setMenuPriority( me.getMenuPriority() );
        menuDetail.setChildren( menuEntityListToMenuDetailList( me.getChildren() ) );

        return menuDetail;
    }

    protected List<MenuEntity> menuDetailListToMenuEntityList(List<MenuDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<MenuEntity> list1 = new ArrayList<MenuEntity>( list.size() );
        for ( MenuDetail menuDetail : list ) {
            list1.add( convertMenuDetailToMenuEntity( menuDetail ) );
        }

        return list1;
    }

    protected List<MenuDetail> menuEntityListToMenuDetailList(List<MenuEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MenuDetail> list1 = new ArrayList<MenuDetail>( list.size() );
        for ( MenuEntity menuEntity : list ) {
            list1.add( convertMenuEntityToMenuDetail( menuEntity ) );
        }

        return list1;
    }
}
