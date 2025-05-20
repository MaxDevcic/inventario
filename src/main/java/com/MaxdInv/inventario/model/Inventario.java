package com.MaxdInv.inventario.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(length = 13, nullable = false)
    private String codigoProducto;

    @Column(length = 50, nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private int cantidad;
}
