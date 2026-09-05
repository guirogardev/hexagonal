package es.tutoriales.hexagonal.usuarios.application.in.crear_usuario;

import es.tutoriales.hexagonal.usuarios.application.out.UsuarioRepository;
import es.tutoriales.hexagonal.usuarios.domain.model.Email;
import es.tutoriales.hexagonal.usuarios.domain.model.Nombre;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;

public class CrearUsuarioService implements CrearUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public CrearUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void ejecutar(CrearUsuarioCommand command) {

        final boolean existeNombre = usuarioRepository.existsByNombre(command.nombre());
        final boolean existeEmail = usuarioRepository.existsByEmail(command.email());

        if (existeNombre || existeEmail) {
            throw new IllegalArgumentException(
                    "Ya existe un usuario con el nombre y/o el email proporcionados"
            );
        }

        final Usuario usuario = Usuario.crear(
                new Nombre(command.nombre()),
                new Email(command.email())
        );

        this.usuarioRepository.guardar(usuario);
    }

}
