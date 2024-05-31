package com.crea_chet.crea_chet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crea_chet.crea_chet.model.Carrito;
import com.crea_chet.crea_chet.repository.CarritoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarritoService {

	private CarritoRepository carritoRepository;
	
	@Autowired
    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }
	
	//Se definen los métodos para realizar operaciones en la DB
	
	//Obtener todos
	public List<Carrito> getAll(){
        return carritoRepository.findAll();
    }
	//Obtener por ID
	public Carrito getById(Long id) {
	    return carritoRepository.findById(id)
	            .orElseThrow( () -> new IllegalStateException("El carrito que quieres obtener no se encuentra registrado"));
	    }
	//Crear un nuevo
	public Carrito postCarrito(Carrito nuevoCarrito) {
        return carritoRepository.save(nuevoCarrito);
    }
	//Actualizar existente
	
	 ///Actualizar
    public Carrito updateCarrito(Carrito carrito, Long id) {
            return carritoRepository.findById(id)
                    .map(carritoMap -> {
                        carritoMap.setCantidad(carrito.getCantidad());

                        return carritoRepository.save(carritoMap);
                    })
                    .orElseThrow( () -> new  IllegalStateException("El carrito que quieres obtener no se encuentra registrado")); //aprovechar la excepcion
        }

	
	//Eliminar por su ID
	public void deleteCarrito(Long id) {
        if(carritoRepository.existsById(id)) {
            carritoRepository.deleteById(id);
        }else {
            //exception
            throw new IllegalStateException("El  carrito que quieres eliminar no se encuentra registrado");
        }
    }
}
