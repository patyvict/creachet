package com.crea_chet.crea_chet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.crea_chet.crea_chet.model.Producto;
import com.crea_chet.crea_chet.service.ProductoService;


@RestController //Marca esta clase como un controlador REST.
@RequestMapping("/api/crea_chet/producto") //Define la raíz del endpoint para este controlador 
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProductoController {
	//Es una instancia del servicio UsuarioService. 
		//Este controlador depende de UsuarioService para la lógica de negocio relacionada con los usuarios.
		private final ProductoService productoService;
		//Inyecta el UsuarioService en este controlador, 
		//lo que permite que este controlador acceda a los métodos proporcionados por el servicio para manipular los usuarios.
		@Autowired
		public ProductoController(ProductoService productoService) {
			this.productoService = productoService;
		}
		//-------Métodos de Mapeo de Endpoints---------------

		//Obtener todos
		//(get) --- http://localhost:8081/producto
		@GetMapping 
		public List<Producto> getAllProductoController(){
			return productoService.getAllProducto();
		}
		//Obtener por ID
		//(get)--- http://localhost:8081/producto/6
		 @GetMapping ("/{id}")
		 public Producto getOneProducto(@PathVariable(name= "id") Long id) {
			 return productoService.getById(id);
		 }
		 
		//Crear un nuevo
			//(Post) ---http://localhost:8081/usuarios
		 @PostMapping
		 public Producto nuevoProducto(@RequestBody Producto producto) {
			 return productoService.postProducto(producto);
		 }
		 
		//Actualizar existente (Todo!)
		@PutMapping("/{id}")
		public Producto updateProducto(@RequestBody Producto producto,@PathVariable(name="id") Long id) {
			return productoService.updateProducto(producto, id);
		}
		//Eliminar por su ID
		//(Delete)http://localhost:8081/usuarios/5 eliminar usuario con id 5
		 @DeleteMapping("/{id}")
		 public void deleteUser(@PathVariable(name="id") Long id) {
			 productoService.deleteProducto(id);
		 }
		
}
