package com.trisul.repository;

import com.trisul.entity.CodeTypeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeTypeRepository extends JpaRepository<CodeTypeEntity, Long> {

  Optional<CodeTypeEntity> findByCodeTypeKey(String codeType);
}
