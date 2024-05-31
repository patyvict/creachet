package com.crea_chet.crea_chet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crea_chet.crea_chet.model.Pago;

import com.crea_chet.crea_chet.service.PagoService;



@RestController
@RequestMapping("/api/crea_chet/pago")

public class PagoController {

    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    //Mapear métodos
    //get All
    @GetMapping
    public List<Pago> getAllController(){
        return pagoService.getAll();
    }

    @PostMapping
      public Pago nuevoPago(@RequestBody Pago pago) {
          return pagoService.postPago(pago);
      }
    //Mapear Delete
    @DeleteMapping ("/{id}")
    public void deletePago(@PathVariable(name="id")Long id) {
        pagoService.deletePago(id);

    }

    //Mapear get by Id
        @GetMapping("/{id}")
        public Pago getOne(@PathVariable(name = "id")Long id) {
            return pagoService.getById(id);

        }

}
