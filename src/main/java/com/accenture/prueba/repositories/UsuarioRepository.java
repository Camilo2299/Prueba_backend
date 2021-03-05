package com.accenture.prueba.repositories;

import com.accenture.prueba.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    
}
