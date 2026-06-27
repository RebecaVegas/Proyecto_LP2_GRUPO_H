package com.tienda_videojuegos.model;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_boleta")
public class Boleta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta")
    private Integer idBoleta;

    @Column(name = "fecha_boleta")
    private LocalDateTime fechaBoleta;

    @Column(name = "total_boleta")
    private Double totalBoleta;

    @OneToMany(mappedBy = "boleta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleBoleta> detalles;
}