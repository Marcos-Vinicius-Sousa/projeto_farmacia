package com.projeto_p2.farmacia.model.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_p2.farmacia.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByLogin(String login);
}
