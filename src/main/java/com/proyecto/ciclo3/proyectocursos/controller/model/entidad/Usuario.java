package com.proyecto.ciclo3.proyectocursos.controller.model.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
    @Id
    private String nombreUsuario;

    private String contraseña;

    private String nombre;

    @Column(unique = true)
    private String correo;

    private Boolean activo;

    private Boolean admin;
}
