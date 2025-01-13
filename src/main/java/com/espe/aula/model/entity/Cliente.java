package com.espe.aula.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe tener un formato válido")
    @Size(max = 100, message = "El email no puede exceder los 100 caracteres")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Pattern(regexp = "^\\+?\\d{0,15}$", message = "El teléfono debe contener solo números y opcionalmente un '+' al inicio")
    @Size(max = 15, message = "El teléfono no puede exceder los 15 caracteres")
    @Column(name = "telefono", length = 15)
    private String telefono;

    @NotNull(message = "La fecha de registro no puede ser nula")
    @PastOrPresent(message = "La fecha de registro no puede ser futura")
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    // Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
