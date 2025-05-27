package com.MaxdInv.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.MaxdInv.inventario.model.Inventario;

@Repository
public class InventarioRepository{

    List<Inventario> inventarios = new ArrayList<>();

    public List<Inventario> readAll()
    {
        return inventarios;
    }

    public Inventario create(Inventario Inventario)
    {
        inventarios.add(Inventario);
        System.out.println(inventarios.toString());
        return Inventario;
    }

    public Inventario read(int id) {
        for (Inventario Inventario : inventarios) {
            if(Inventario.getId()==id)
            {
                return Inventario;
            }
        }
        return null;
    }

    public Inventario update(int id, Inventario Inventariomod)
    {
        Inventario i = read(id);
        if(i!=null){
            i.setCodigoProducto(Inventariomod.getCodigoProducto());
            i.setNombreProducto(Inventariomod.getNombreProducto());
            i.setCantidad(Inventariomod.getCantidad());
            return i;
        }
        return null;
    }

    public Inventario aumentarCantidad(int id, String cod, Inventario Inventariomod, int cantalt)
    {
        Inventario i = read(id);
        Inventario p = readbycodigo(cod);
        if(i!=null && p!=null){
            i.setCantidad(Inventariomod.getCantidad()+cantalt);
            return i;
        }
        return null;
    }

    public String delete(int id) {
        Inventario kill = read(id);
        if(kill!=null)
        {
            inventarios.remove(kill);
        }
        return null;
    }

    public Inventario readbycodigo(String code) {
        for (Inventario i : inventarios) {
            if(i.getCodigoProducto().equals(code)){
                return i;
            }
        }
        return null;
    }
}
