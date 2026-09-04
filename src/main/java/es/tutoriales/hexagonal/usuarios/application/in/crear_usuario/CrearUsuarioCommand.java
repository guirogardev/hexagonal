package es.tutoriales.hexagonal.usuarios.application.in.crear_usuario;

public record CrearUsuarioCommand(
        String nombre,
        String email
) {
}
