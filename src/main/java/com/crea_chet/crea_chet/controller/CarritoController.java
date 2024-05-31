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
import com.crea_chet.crea_chet.model.Carrito;
import com.crea_chet.crea_chet.service.CarritoService;


@RestController
@RequestMapping("/api/crea_chet/carrito")//endpoint
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CarritoController {

    private final CarritoService carritoService;

    @Autowired
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    // Mapear metodos

    //Obtener todos
    @GetMapping
    public List<Carrito> getAllController(){
        return carritoService.getAll();
    }


     //Mapear get by ID
     @GetMapping ("/{id}")
     public Carrito getOne(@PathVariable(name= "id") Long id) {
          return carritoService.getById(id);
     }


    //Crear un nuevo
    @PostMapping
    public Carrito nuevoCarrito(@RequestBody Carrito carrito) {
        return carritoService.postCarrito(carrito);
    }

    // Actualizar existente
    @PutMapping("/{id}")
      public Carrito updateCarrito(@RequestBody Carrito carrito,@PathVariable(name="id") Long id) {
          return carritoService.updateCarrito(carrito, id);
      }

    // Eliminar por su ID
    @DeleteMapping("/{id}")
      public void deleteCarrito(@PathVariable(name="id") Long id) {
                  carritoService.deleteCarrito(id);

      }


}