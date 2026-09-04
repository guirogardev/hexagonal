package es.tutoriales.hexagonal.usuarios.application.out;

import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;

public interface UsuarioRepository {
    void guardar(Usuario usuario);
}
