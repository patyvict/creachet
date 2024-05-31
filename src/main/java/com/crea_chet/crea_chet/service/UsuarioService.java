package com.crea_chet.crea_chet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crea_chet.crea_chet.model.Usuario;
import com.crea_chet.crea_chet.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	//Se definen los métodos para realizar operaciones en la DB
	
	//Obtener todos
		public List<Usuario> getAllUsuario(){
		return usuarioRepository.findAll();
		}
	
		
	//Obtener por ID
		public Usuario getById(Long id) {
			return usuarioRepository.findById(id)
					.orElseThrow( () -> new IllegalStateException("El usuario que quieres obtener no se encuentra registrado"));
			}
	
		
	//Obtener por email
		public Usuario getByEmail(String email) {
			return usuarioRepository.findByEmail(email);
		}
		
		
	//Crear un nuevo
		public Usuario postUsuario(Usuario nuevoUsuario) {
			return usuarioRepository.save(nuevoUsuario);
		}
	
		
	//Actualizar existente
		//carrito, creationDate, email, id, lastName, middleName, name, password, phoneNumber, role
		public Usuario updateUsuario(Usuario usuario, Long id) {
			return usuarioRepository.findById(id)
					.map(userMap -> {
						userMap.setName(usuario.getName());
						userMap.setLastName(usuario.getLastName());
						userMap.setMiddleName(usuario.getMiddleName());
						userMap.setEmail(usuario.getEmail());
						userMap.setPassword(usuario.getPassword());
						userMap.setPhoneNumber(usuario.getPhoneNumber());
						return usuarioRepository.save(userMap);
					})
					.orElseThrow( () -> new  IllegalStateException("El usuario que quieres obtener no se encuentra registrado")); //aprovechar la excepcion 			
		}
		
	
	//Eliminar por su ID
		 public void deleteUsuario(Long id) {
		   	 if(usuarioRepository.existsById(id)) {
		   		 usuarioRepository.deleteById(id);
		   	 }else {
		   		 //exception
		   		 throw new IllegalStateException("El usuario que quieres eliminar no se encuentra registrado");
		   	 }
		    }
		    
		 
}
