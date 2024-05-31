package com.crea_chet.crea_chet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crea_chet.crea_chet.model.Pago;
import com.crea_chet.crea_chet.repository.PagoRepository;

@Service
public class PagoService {

	private PagoRepository pagoRepository;
	
	@Autowired
    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }
	
	//Se definen los métodos para realizar operaciones en la DB
	
	//Obtener todos
	public List<Pago> getAll(){
        return pagoRepository.findAll();
    }
	
	//Obtener por ID
	public Pago getById(Long id) {
	    return pagoRepository.findById(id)
	            .orElseThrow( () -> new IllegalStateException("El método de pago que quieres obtener no se encuentra"));
	    }
	
	//Crear un nuevo
	public Pago postPago(Pago nuevoPago) {
        return pagoRepository.save(nuevoPago);
    }
	//Eliminar por su ID
	public void deletePago(Long id) {
        if(pagoRepository.existsById(id)) {
        	pagoRepository.deleteById(id);
        }else {
            //exception
            throw new IllegalStateException("El  pago que quieres eliminar no se encuentra registrado");
        }
    }
	
}
