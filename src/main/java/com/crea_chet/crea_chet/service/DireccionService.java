package com.crea_chet.crea_chet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crea_chet.crea_chet.model.Direccion;
import com.crea_chet.crea_chet.repository.DireccionRepository;

@Service
public class DireccionService {

	private DireccionRepository direccionRepository;
	
	@Autowired
    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }
	
	//Se definen los métodos para realizar operaciones en la DB
	
	//Obtener todos
	public List<Direccion> getAll(){
        return direccionRepository.findAll();
    }
	
	//Obtener por ID
	public Direccion getById(Long id) {
	    return direccionRepository.findById(id)
	            .orElseThrow( () -> new IllegalStateException("La direccion que quieres obtener no se encuentra"));
	    }
	
	//Crear un nuevo
	public Direccion postDireccion(Direccion nuevoDireccion) {
        return direccionRepository.save(nuevoDireccion);
    }
	
	//Eliminar por su ID
	public void deleteDireccion(Long id) {
        if(direccionRepository.existsById(id)) {
            direccionRepository.deleteById(id);
        }else {
            //exception
            throw new IllegalStateException("La direccion  que quieres eliminar no se encuentra registrado");
        }
    }
}
