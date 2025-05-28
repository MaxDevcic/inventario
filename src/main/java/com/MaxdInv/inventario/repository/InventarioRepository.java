package com.MaxdInv.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MaxdInv.inventario.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Long>{
    
    Inventario findAllByIdAndCodigoproducto(int id, String codproducto);

    List<Inventario> findAllById(int id);

    List<Inventario> findAll();

    @SuppressWarnings("unchecked")
    Inventario save(Inventario inventario);
}
