package com.MaxdInv.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MaxdInv.inventario.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Integer>{
    
    Inventario findByIdAndCodigoproducto(Long id, Long codproducto);

    List<Inventario> findAllById(Long id);

    List<Inventario> findAll();

    @SuppressWarnings("unchecked")
    Inventario save(Inventario inventario);
}
