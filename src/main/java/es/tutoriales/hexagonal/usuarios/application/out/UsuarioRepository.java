package es.tutoriales.hexagonal.usuarios.application.out;

import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository {
    void guardar(Usuario usuario);

    Optional<Usuario> getById(UUID id);

    boolean existsByNombreAndEmailAndNoId(UUID id, String nombre, String email);

    boolean existsByNombre(String nombre);

    boolean existsByEmail(String email);
}
