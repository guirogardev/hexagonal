package es.tutoriales.hexagonal.usuarios.application.in.obtener_usuario;

import es.tutoriales.hexagonal.usuarios.application.out.UsuarioRepository;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;

import java.util.UUID;

public class ObtenerUsuarioService implements ObtenerUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public ObtenerUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario ejecutar(UUID id) {
        return this.usuarioRepository.getById(id).orElseThrow(() -> new IllegalArgumentException(
                "No existe ningún usuario con el identificador proporcionado."
        ));
    }
}
