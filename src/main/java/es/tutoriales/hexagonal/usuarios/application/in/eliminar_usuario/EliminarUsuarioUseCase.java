package es.tutoriales.hexagonal.usuarios.application.in.eliminar_usuario;

import java.util.UUID;

public interface EliminarUsuarioUseCase {
    void ejecutar(UUID id);
}
