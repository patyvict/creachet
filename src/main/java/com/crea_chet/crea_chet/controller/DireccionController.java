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

import com.crea_chet.crea_chet.model.Direccion;

import com.crea_chet.crea_chet.service.DireccionService;

@RestController
@RequestMapping("/api/crea_chet/direccion")//endpoint

public class DireccionController {
    private final DireccionService direccionService;

    @Autowired
    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    /* Mapeamos metodos*/

    //Obtener todos
    @GetMapping
    public List<Direccion> getAllController(){
        return direccionService.getAll();
    }

    // Obetener por ID
    @GetMapping ("/{id}")
    public Direccion getOne(@PathVariable(name= "id") Long id) {
        return direccionService.getById(id);
    }

    //Crear un nuevo
    @PostMapping
    public Direccion nuevoDireccion(@RequestBody Direccion direccion) {
        return direccionService.postDireccion(direccion);
    }

    // Eliminar por su ID
    @DeleteMapping("/{id}")
    public void deleteDireccion(@PathVariable(name="id") Long id) {
        direccionService.deleteDireccion(id);
    }


}