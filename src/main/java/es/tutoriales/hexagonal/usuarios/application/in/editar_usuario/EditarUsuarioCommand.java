package es.tutoriales.hexagonal.usuarios.application.in.editar_usuario;

import java.util.UUID;

public record EditarUsuarioCommand(UUID id, String nombre, String email) {
}
