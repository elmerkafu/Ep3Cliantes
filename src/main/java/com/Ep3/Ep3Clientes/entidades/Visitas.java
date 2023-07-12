package com.Ep3.Ep3Clientes.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_visitas")
@Data

public class Visitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "local", nullable = false, length = 150)
    private String local;

    @Column(name = "dniAfiliado", nullable = false, length = 8)
    private String dniAfiliado;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;

}
