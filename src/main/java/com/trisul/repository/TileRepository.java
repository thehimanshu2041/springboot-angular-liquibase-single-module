package com.trisul.repository;

import com.trisul.entity.TileEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TileRepository extends JpaRepository<TileEntity, Long> {

  List<TileEntity> findAllByTileIsAccessedAndTileIsDeleteOrderByTilePriorityAsc(
      boolean tileIsAccessed, boolean tileIsDeleted);
}
