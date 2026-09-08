package es.tutoriales.hexagonal.usuarios.infrastructure.in.graphql.dto;

public record EditarUsuarioGraphQLDTO (
        String nombre,
        String email
) {
}
