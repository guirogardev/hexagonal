package es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    private UUID id;

    private String nombre;

    private String email;

    protected UsuarioEntity() {
    }

    public UsuarioEntity(
            UUID id,
            String nombre,
            String email
    ) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
