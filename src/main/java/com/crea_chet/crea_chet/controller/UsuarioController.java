package com.crea_chet.crea_chet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crea_chet.crea_chet.model.Usuario;
import com.crea_chet.crea_chet.service.UsuarioService;


@RestController //Marca esta clase como un controlador REST.
@RequestMapping("/api/crea_chet/usuarios") //Define la raíz del endpoint para este controlador 
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {
	//Es una instancia del servicio UsuarioService. 
		//Este controlador depende de UsuarioService para la lógica de negocio relacionada con los usuarios.
		private final UsuarioService usuarioService;
		//Inyecta el UsuarioService en este controlador, 
		//lo que permite que este controlador acceda a los métodos proporcionados por el servicio para manipular los usuarios.
		@Autowired
		public UsuarioController(UsuarioService usuarioService) {
			this.usuarioService = usuarioService;
		}
		
		//-------Métodos de Mapeo de Endpoints---------------
		//Obtener todos
		//(get)--- http://localhost:8081/usuarios
		@GetMapping
		public List<Usuario> getAllUsuarioController(){
			return usuarioService.getAllUsuario();
		}
		
		//Obtener por ID
		//(get)--- http://localhost:8081/usuarios/6
		 @GetMapping ("/{id}")
		  public Usuario getOne(@PathVariable(name= "id") Long id) {
			  return usuarioService.getById(id);
		  }
		
		//Obtener por email 
		 //(get)--- http://localhost:8081/usuarios/email?email-user=valeria@gmail.com
		 @GetMapping("/email")
		  public ResponseEntity<Usuario> getByEmail(@RequestParam(name="email-user")String correo_electronico){
			  Usuario usuario= usuarioService.getByEmail(correo_electronico);
			  if(usuario == null) {
				  throw new IllegalStateException("El usuario que quieres obtener no se encuentra registrado"); //aprovechar la excepcion 
			  }
			  return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		  }

		
		//Crear un nuevo
		//(Post) ---http://localhost:8081/usuarios
		/* {
				"name": "Paola",
				"lastName": "Palacios",
				"middleName": "Figueroa",
				"phoneNumber": "7775663117",
				"email": "paola@gmail.com",
				"password": "12345Pao",
	            "role":"CLIENTE"
	}*/
		@PostMapping
		public Usuario nuevoUsaurio(@RequestBody Usuario usaurio) {
			return usuarioService.postUsuario(usaurio);
		}
		
		//Actualizar existente (Toda!)
		//(Post) ---http://localhost:8081/usuarios/13 (necesita todos los campos en el JSON
		 /*{
			"nombre": "New Paola",
			"apellidoPaterno": "New Palacios",
			"apellidoMaterno": "Figueroa",
			"numeroTelefono": "New 7775663117",
			"correo_electronico": "paola@gmail.com",
			"contrasena": "12345Pao"
			}*/
		 @PutMapping("/{id}")
		  public Usuario updateUsuario(@RequestBody Usuario usuario,@PathVariable(name="id") Long id) {
			  return usuarioService.updateUsuario(usuario, id);  
		  }
		
		 
		 
		//Eliminar por su ID
		//(Delete)http://localhost:8081/usuarios/5 eliminar usuario con id 5
		 @DeleteMapping("/{id}")
		  public void deleteUsuario(@PathVariable(name="id") Long id) {
			  		usuarioService.deleteUsuario(id);  
			  		
		  }
		 
		
		
}
