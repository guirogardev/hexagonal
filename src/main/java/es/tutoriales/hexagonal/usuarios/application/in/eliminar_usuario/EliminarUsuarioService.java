package es.tutoriales.hexagonal.usuarios.application.in.eliminar_usuario;

import es.tutoriales.hexagonal.usuarios.application.out.UsuarioRepository;

import java.util.UUID;

public class EliminarUsuarioService implements EliminarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public EliminarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void ejecutar(UUID id) {
        this.usuarioRepository.deleteById(id);
    }
}
