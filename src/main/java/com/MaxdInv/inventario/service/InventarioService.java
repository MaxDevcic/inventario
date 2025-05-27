package com.MaxdInv.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MaxdInv.inventario.model.Inventario;
import com.MaxdInv.inventario.repository.InventarioRepository;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public Inventario guardar(Inventario inventario){
        return inventarioRepository.create(inventario);
    
    }

    public List<Inventario> listartodas(){
        return inventarioRepository.readAll();
    }

    public Inventario buscarporid(int id) {
        return inventarioRepository.read(id);
    }

    public Inventario modificarInventario(int id, Inventario inventariomod)
    {
        return inventarioRepository.update(id, inventariomod);
    }

    public Inventario aumentarInventario(int id, String cod, Inventario inventariomod, int cantalt)
    {
        return inventarioRepository.aumentarCantidad(id, cod, inventariomod, cantalt);
    }

    public String eliminarInventario(int id)
    {
        inventarioRepository.delete(id);
        return "Inventario eliminada";
    }

    public Inventario buscarporrut(String code) {
        return inventarioRepository.readbycodigo(code);
    }
}
