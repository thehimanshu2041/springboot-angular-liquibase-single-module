package com.trisul.repository;

import com.trisul.entity.StateEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {

  List<StateEntity> findByStateCountryIdOrderByStatePriorityAsc(Long countryId);

  Optional<StateEntity> findByStateID(Long stateId);

  Optional<StateEntity> findByStateKey(String stateKey);
}
