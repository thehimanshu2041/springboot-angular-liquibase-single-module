package com.trisul.repository;

import com.trisul.entity.IPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPRepository extends JpaRepository<IPEntity, Long> {}
