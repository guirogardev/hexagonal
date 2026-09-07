package es.tutoriales.hexagonal.usuarios.application.in.obtener_usuario;

import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;

import java.util.UUID;

public interface ObtenerUsuarioUseCase {
    Usuario ejecutar(UUID id);
}
