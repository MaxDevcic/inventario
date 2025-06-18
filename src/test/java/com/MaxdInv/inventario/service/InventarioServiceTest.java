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

}
