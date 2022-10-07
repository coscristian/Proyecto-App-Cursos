package com.proyecto.ciclo3.proyectocursos.controller.model.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
