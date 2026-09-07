package es.tutoriales.hexagonal.usuarios.application.in.editar_usuario;

import es.tutoriales.hexagonal.usuarios.application.out.UsuarioRepository;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;

public class EditarUsuarioService implements EditarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public EditarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario ejecutar(EditarUsuarioCommand command) {
        final Usuario usuario = this.usuarioRepository
                .getById(command.id())
                .orElseThrow();

        final boolean existeNombreEmail = this.usuarioRepository.existsByNombreAndEmailAndNoId(command.id(), command.nombre(), command.email());

        if (existeNombreEmail) {
            throw new IllegalArgumentException(
                    "Ya existe un usuario con el nombre y/o el email proporcionados"
            );
        }

        final Usuario usuarioEditado = usuario.editar(command.nombre(), command.email());

        this.usuarioRepository.guardar(usuarioEditado);
        return usuarioEditado;
    }
}
