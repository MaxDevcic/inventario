package com.MaxdInv.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MaxdInv.inventario.model.Inventario;
import com.MaxdInv.inventario.service.InventarioService;

@RequestMapping("/api/inventario")
@Controller
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @PostMapping("/{id}")
    public ResponseEntity<Inventario> postInventario(@RequestBody Inventario inventario) {
        Inventario buscado = inventarioService.findAllByIdAndCodigoproducto(inventario.getId(),inventario.getCodigoproducto());
        if (buscado == null) {
            return new ResponseEntity<>(inventarioService.save(inventario), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}/{codprod}/cantidad")
    public ResponseEntity<Inventario> putInventario(@PathVariable int id, String codprod,@RequestBody int cantidad) {
        Inventario buscado = inventarioService.findAllByIdAndCodigoproducto(id, codprod);
        if (buscado != null) {
            return new ResponseEntity<>(inventarioService.nuevaCant(buscado,cantidad), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> getAll(){
        List<Inventario> inventarios = inventarioService.findAll();
        if(!inventarios.isEmpty()){
            return new ResponseEntity<>(inventarios, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<Inventario>> getSome(@PathVariable int id){
        List<Inventario> inventariosEncontrados = inventarioService.findAllById(id);
        if(!inventariosEncontrados.isEmpty()){
            return new ResponseEntity<>(inventariosEncontrados, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
