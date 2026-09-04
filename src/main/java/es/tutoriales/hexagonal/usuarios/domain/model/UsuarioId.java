package es.tutoriales.hexagonal.usuarios.domain.model;

import java.util.UUID;

public record UsuarioId(UUID id) {

    public UsuarioId {
        if (id == null) {
            throw new IllegalArgumentException("El identificador de usuario no puede ser nulo.");
        }
    }

    public static UsuarioId generar() {
        return new UsuarioId(UUID.randomUUID());
    }
}
