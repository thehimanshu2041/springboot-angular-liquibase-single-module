package com.trisul.repository;

import com.trisul.entity.MenuEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

  List<MenuEntity> findAllByMenuIsAuthReqOrderByMenuPriorityAsc(Boolean authStatus);
}
