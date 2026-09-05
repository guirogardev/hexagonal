package es.tutoriales.hexagonal.usuarios.application.in.editar_usuario;

import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;

public interface EditarUsuarioUseCase {
    Usuario ejecutar(EditarUsuarioCommand command);
}
