package com.cosaproyectosistemas.LukkyFrost.cosa.repositories;

import com.cosaproyectosistemas.LukkyFrost.cosa.models.Paismodelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CosaRepository extends CrudRepository<Paismodelo, Long> {
}