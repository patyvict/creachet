package com.crea_chet.crea_chet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.crea_chet.crea_chet.model.Pedido;
import com.crea_chet.crea_chet.service.PedidoService;






@RestController
@RequestMapping("/api/crea_chet/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    //Mapear métodos
    //get All
    @GetMapping
    public List<Pedido> getAllController(){
        return pedidoService.getAll();
    }



    @PostMapping
      public Pedido nuevoPedido(@RequestBody Pedido pedido) {
          return pedidoService.postPedido(pedido);
      }


    //Mapear get by Id
    @GetMapping("/{id}")
    public Pedido getOne(@PathVariable(name = "id")Long id) {
        return pedidoService.getById(id);

    }

    //Mapear put, modificar el usuario accediendo mediante Id
    @PutMapping("/{id}")
    public Pedido updateUser(@RequestBody Pedido pedido, @PathVariable(name="id")Long id){
        return pedidoService.updatePedido(pedido, id);
    }





}