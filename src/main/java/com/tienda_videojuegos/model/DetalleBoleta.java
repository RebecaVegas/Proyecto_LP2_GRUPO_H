package com.tienda_videojuegos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_detalle_boleta")
public class DetalleBoleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_boleta", nullable = false)
    private Boleta boleta;

    @ManyToOne
    @JoinColumn(name = "id_juego", nullable = false)
    private Juego juego;

    private Integer cantidad;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    private Double subtotal;
}