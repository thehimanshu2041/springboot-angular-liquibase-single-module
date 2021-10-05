package com.trisul.repository;

import com.trisul.entity.CodeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<CodeEntity, Long> {

  Optional<CodeEntity> findByCodeID(Long codeKey);

  Optional<CodeEntity> findByCodeKey(String codeKey);
}
