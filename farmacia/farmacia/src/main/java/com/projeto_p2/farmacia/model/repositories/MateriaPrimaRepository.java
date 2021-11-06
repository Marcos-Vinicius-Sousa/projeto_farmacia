package com.projeto_p2.farmacia.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_p2.farmacia.model.entities.MateriaPrima;

@Repository
public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Long>{

}
