package com.Ep3.Ep3Clientes.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_cliente")
@Data
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 150)
    private String apellido;

    @Column(name = "correo", nullable = false, length = 150, unique = true)
    private String correo;

    @Column(name = "celular", nullable = false, length = 9, unique = true)
    private String celular;

    @Column(name = "fechaCreacion")
    private String fechaCreacion;

    @Column(name = "fechaModificacion")
    private String fechaModificacion;

}
