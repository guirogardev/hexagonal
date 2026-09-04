package es.tutoriales.hexagonal.usuarios.domain.model;

public record Nombre(String nombre) {
    public Nombre {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre debe estar informado.");
        }
    }
}
