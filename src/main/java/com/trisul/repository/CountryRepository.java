package com.trisul.repository;

import com.trisul.entity.CountryEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

  Optional<CountryEntity> findByCountryKey(String countryKey);

  Optional<CountryEntity> findByCountryID(Long countryId);
}
