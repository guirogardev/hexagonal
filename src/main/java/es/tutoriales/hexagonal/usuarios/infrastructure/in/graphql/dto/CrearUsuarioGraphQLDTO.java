package es.tutoriales.hexagonal.usuarios.infrastructure.in.graphql.dto;

public record CrearUsuarioGraphQLDTO (
        String nombre,
        String email
) {
}
