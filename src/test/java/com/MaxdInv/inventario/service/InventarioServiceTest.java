package com.MaxdInv.inventario.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.MaxdInv.inventario.model.Inventario;
import com.MaxdInv.inventario.repository.InventarioRepository;
 
import java.util.Arrays;
import java.util.List;
//import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
/*import static org.mockito.ArgumentMatchers.any;*/
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class InventarioServiceTest {
    @Mock
    private InventarioRepository inventarioRepository;

    @InjectMocks
    private InventarioService inventarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllByIdAndCodigoproducto(){
        Inventario inv = new Inventario(1L, 1L, "Gomitas", 10);
        when(inventarioRepository.findByIdAndCodigoproducto(1L,1L)).thenReturn(inv);

        Inventario resultado = inventarioService.findByIdAndCodigoproducto(1L,1L);
        assertThat(resultado.getId()).isEqualTo(inv.getId());
        assertThat(resultado.getCodigoproducto()).isEqualTo(inv.getCodigoproducto());
        assertThat(resultado.getNombreproducto()).isEqualTo(inv.getNombreproducto());
        assertThat(resultado.getCantidad()).isEqualTo(inv.getCantidad());
        verify(inventarioRepository).findByIdAndCodigoproducto(1L, 1L);
    }

    @Test
    void testFindAll(){
        Inventario inv1 = new Inventario(1L, 1L, "Gomitas", 10);
        Inventario inv2 = new Inventario(1L, 2L, "Coca-cola", 7);
        Inventario inv3 = new Inventario(3L, 1L, "Gomitas", 5);
        when(inventarioRepository.findAll()).thenReturn(Arrays.asList(inv1, inv2, inv3));

        List<Inventario> resultado = inventarioService.findAll();
        assertThat(resultado).hasSize(3).contains(inv1, inv2, inv3);
        verify(inventarioRepository).findAll();
    }

    @Test
    void testSave(){
        Inventario inventario = new Inventario(1L,1L,"Sprite",15);
        Inventario invsave = new Inventario(1L,1L,"Sprite",15);
        when(inventarioRepository.save(inventario)).thenReturn(invsave);

        Inventario resultado = inventarioService.save(inventario);
        assertThat(resultado).isEqualTo(invsave);
        verify(inventarioRepository).save(inventario);
    }

    @Test
    void testFindAllById(){
        Inventario i1 = new Inventario(1L,1L,"Sprite",15);
        Inventario i3 = new Inventario(1L,2L,"CocaCola",20);
        when(inventarioRepository.findAllById(1L)).thenReturn(Arrays.asList(i1,i3));

        List<Inventario> resultado = inventarioService.findAllById(1L);
        assertThat(resultado).hasSize(2).contains(i1,i3);
        verify(inventarioRepository).findAllById(1L);
    }

    @Test
    void testNuevaCant(){
        Inventario inventarioViejo = new Inventario(1L,1L,"Sprite",15);
        int cantidad = 1;
        Inventario inventarioNuevo = new Inventario(1L,1L,"Sprite",16);
        when(inventarioRepository.findByIdAndCodigoproducto(1L, 1L)).thenReturn(inventarioNuevo);
        when(inventarioRepository.save(any(Inventario.class))).thenAnswer(i -> i.getArgument(0));

        Inventario resultado = inventarioService.nuevaCant(inventarioViejo, cantidad);
        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getCodigoproducto()).isEqualTo(1L);
        assertThat(resultado.getNombreproducto()).isEqualTo("Sprite");
        assertThat(resultado.getCantidad()).isEqualTo(16);
        verify(inventarioRepository).save(inventarioNuevo);
    }
}
