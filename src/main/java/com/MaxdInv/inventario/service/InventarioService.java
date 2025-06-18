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

    public Inventario findByIdAndCodigoproducto(Long id, Long codproducto){
        return inventarioRepository.findByIdAndCodigoproducto(id, codproducto);
    }

    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    public Inventario save(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public List<Inventario> findAllById(Long id) {
        return inventarioRepository.findAllById(id);
    }

    public Inventario nuevaCant(Inventario inventarionuevo, int cantidad) {
        int cantidadAnterior = inventarionuevo.getCantidad();
        inventarionuevo.setCantidad(cantidad+cantidadAnterior);
        return inventarioRepository.save(inventarionuevo);
    }

    
}
