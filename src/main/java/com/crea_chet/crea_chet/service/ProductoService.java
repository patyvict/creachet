package com.crea_chet.crea_chet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crea_chet.crea_chet.model.Producto;
import com.crea_chet.crea_chet.repository.ProductoRepository;

@Service
public class ProductoService {
	private ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	//Se definen los métodos para realizar operaciones en la DB
	
		//Obtener todos
	public List<Producto> getAllProducto(){
		return productoRepository.findAll();
		}
	
	
		//Obtener por ID
	public Producto getById(Long id) {
		return productoRepository.findById(id)
				.orElseThrow( () -> new IllegalStateException("El producto que quieres obtener no se encuentra registrado"));
		}
	
	
		//Crear un nuevo
	public Producto postProducto(Producto nuevoProducto) {
		return productoRepository.save(nuevoProducto);
	}
	
	
		//Actualizar existente
	/*cantidad, categoria, descripcion, id, imagen, nombre, pedido, precio, variacion*/
	public Producto updateProducto(Producto producto, Long id) {
		return productoRepository.findById(id)
				.map(productoMap -> {
					productoMap.setCategoria(producto.getCategoria());
					productoMap.setDescripcion(producto.getDescripcion());
					productoMap.setImagen(producto.getImagen());
					productoMap.setNombre(producto.getNombre());
					productoMap.setStock(producto.getStock());
					productoMap.setPrecio(producto.getPrecio());
					productoMap.setVariacion(producto.getVariacion());	
					return productoRepository.save(productoMap);
				})
				.orElseThrow( () -> new  IllegalStateException("El producto que quieres obtener no se encuentra registrado")); //aprovechar la excepcion 			
	}
	
	
		//Eliminar por su ID
	 public void deleteProducto(Long id) {
	   	 if(productoRepository.existsById(id)) {
	   		productoRepository.deleteById(id);
	   	 }else {
	   		 //exception
	   		 throw new IllegalStateException("El producto que quieres eliminar no se encuentra registrado");
	   	 }
	    }
	    
}
