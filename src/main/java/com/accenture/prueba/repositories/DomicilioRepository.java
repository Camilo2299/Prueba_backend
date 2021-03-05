package com.accenture.prueba.repositories;

import com.accenture.prueba.models.DomicilioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends CrudRepository<DomicilioModel, Long> {
    
}
