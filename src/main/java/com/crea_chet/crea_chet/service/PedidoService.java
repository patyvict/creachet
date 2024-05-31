package com.crea_chet.crea_chet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crea_chet.crea_chet.model.Pedido;
import com.crea_chet.crea_chet.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoService {

	private PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	//Se definen los métodos para realizar operaciones en la DB
	
	//Obtener todos
	public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }
	//Obtener por ID
	public Pedido getById(Long id) {
		return pedidoRepository.findById(id)
				.orElseThrow( () -> new IllegalStateException("El pedido que quieres obtener no se encuentra registrado"));
		}
	//Crear un nuevo
	public Pedido postPedido(Pedido nuevoPedido) {
        return pedidoRepository.save(nuevoPedido);
    }
	
	//Actualizar existente (Solo se actualiza el Status)
	public Pedido updatePedido(Pedido pedido, Long id) {
		return pedidoRepository.findById(id)
				.map(pedidoMap -> {
					pedidoMap.setEstatus_pedido(pedido.getEstatus_pedido());
			
					return pedidoRepository.save(pedidoMap);
				})
				.orElseThrow( () -> new  IllegalStateException("El producto que quieres obtener no se encuentra registrado")); //aprovechar la excepcion 			
	}
	
	
}
