package com.trisul.repository;

import com.trisul.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author h3kumar
 * @since 28/03/2021
 */
@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {}
