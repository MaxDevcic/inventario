package com.MaxdInv.inventario.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.MaxdInv.inventario.model.Inventario;
import com.MaxdInv.inventario.repository.InventarioRepository;
/* 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;*/

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
    void testfindAllByIdAndCodigoproducto(){
        Inventario inv = new Inventario(1L, 1L, "Gomitas", 10);
        when(inventarioRepository.findByIdAndCodigoproducto(1L,1L)).thenReturn(inv);

        Inventario resultado = inventarioService.findByIdAndCodigoproducto(1L,1L);
        assertThat(resultado.getId()).isEqualTo(inv.getId());
        assertThat(resultado.getCodigoproducto()).isEqualTo(inv.getCodigoproducto());
        assertThat(resultado.getNombreproducto()).isEqualTo(inv.getNombreproducto());
        assertThat(resultado.getCantidad()).isEqualTo(inv.getCantidad());
        verify(inventarioRepository).findByIdAndCodigoproducto(1L, 1L);
    }
}
