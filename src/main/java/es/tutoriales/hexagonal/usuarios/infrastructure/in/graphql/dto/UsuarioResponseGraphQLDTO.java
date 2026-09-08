package es.tutoriales.hexagonal.usuarios.infrastructure.in.graphql.dto;

import java.util.UUID;

public record UsuarioResponseGraphQLDTO (
        UUID id,
        String nombre,
        String email
) {
}
