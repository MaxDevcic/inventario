package com.MaxdInv.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MaxdInv.inventario.model.Inventario;
import com.MaxdInv.inventario.service.InventarioService;

@RequestMapping("/api/personas")
@Controller
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public Inventario crearPersona(@RequestBody Inventario persona) {
        System.out.println();
        return inventarioService.guardar(persona);
    }

    @GetMapping
    public List<Inventario> listaPersonas() {
        return inventarioService.listartodas();
    }

    @GetMapping("/{id}")
    public Inventario getbyid(@PathVariable int id) {
        return inventarioService.buscarporid(id);
    }
    
    @GetMapping("/codigo={codigo}") // (/filtro/rut/{rut})
    public Inventario getbyRut(@PathVariable String code) {
        return inventarioService.buscarporrut(code);
    }

    @PutMapping("/{id}")
    public Inventario modifyInventario(@PathVariable int id, @RequestBody Inventario personamod) {  
        return inventarioService.modificarInventario(id, personamod);
    }

    @PutMapping("/{id}")
    public Inventario aumentarCantidad(@PathVariable int id, @RequestBody Inventario personamod) {  
        return inventarioService.modificarInventario(id, personamod);
    }
    
    @DeleteMapping("/{id}")
    public String deleteInventario(@PathVariable int id)
    {
        return inventarioService.eliminarInventario(id);
    }
}
