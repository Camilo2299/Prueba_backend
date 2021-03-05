package com.accenture.prueba.repositories;

import com.accenture.prueba.models.DetallePedidoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends CrudRepository<DetallePedidoModel, Long> {
    

}
