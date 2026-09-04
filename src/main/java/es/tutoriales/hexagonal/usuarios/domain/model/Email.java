package es.tutoriales.hexagonal.usuarios.domain.model;

public record Email(String email) {

    public Email {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email debe estar informado.");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }
    }
}
