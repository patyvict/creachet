package com.crea_chet.crea_chet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crea_chet.crea_chet.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.email = ?1")
	  Usuario findByEmail(String email);
}
