package com.MaxdInv.inventario.controller;

import com.MaxdInv.inventario.model.Inventario;
import com.MaxdInv.inventario.service.InventarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InventarioController.class)
class InventarioControllerTest {
    
     @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private InventarioService inventarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPostInventario() throws JsonProcessingException, Exception{
        Inventario invNuevo = new Inventario(1L, 1L, "CocaCola", 1);
        Inventario invGuardado = new Inventario(1L, 1L, "CocaCola", 1);
        Mockito.when(inventarioService.save(invNuevo)).thenReturn(invGuardado);

        mockMvc.perform(post("/api/inventario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invNuevo)))
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.id").value(1L))
                        .andExpect(jsonPath("$.codigoproducto").value(1L))
                        .andExpect(jsonPath("$.nombreproducto").value("CocaCola"))
                        .andExpect(jsonPath("$.cantidad").value(1));
    }
}
