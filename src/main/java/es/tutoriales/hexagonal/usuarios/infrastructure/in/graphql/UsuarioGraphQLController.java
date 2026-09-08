package es.tutoriales.hexagonal.usuarios.infrastructure.in.graphql;

import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioCommand;
import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.editar_usuario.EditarUsuarioCommand;
import es.tutoriales.hexagonal.usuarios.application.in.editar_usuario.EditarUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.eliminar_usuario.EliminarUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.obtener_usuario.ObtenerUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;
import es.tutoriales.hexagonal.usuarios.infrastructure.in.graphql.dto.CrearUsuarioGraphQLDTO;
import es.tutoriales.hexagonal.usuarios.infrastructure.in.graphql.dto.EditarUsuarioGraphQLDTO;
import es.tutoriales.hexagonal.usuarios.infrastructure.in.graphql.dto.UsuarioResponseGraphQLDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UsuarioGraphQLController {
    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final EditarUsuarioUseCase editarUsuarioUseCase;
    private final ObtenerUsuarioUseCase obtenerUsuarioUseCase;
    private final EliminarUsuarioUseCase eliminarUsuarioUseCase;

    @QueryMapping
    public Usuario obtenerUsuario(@Argument UUID id) {
        return this.obtenerUsuarioUseCase.ejecutar(id);
    }

    @MutationMapping
    public boolean crearUsuario(@Argument CrearUsuarioGraphQLDTO input) {
        final CrearUsuarioCommand command = new CrearUsuarioCommand(
                input.nombre(),
                input.email()
        );
        this.crearUsuarioUseCase.ejecutar(command);
        return true;
    }

    @MutationMapping
    public UsuarioResponseGraphQLDTO editarUsuario(
            UUID id,
            EditarUsuarioGraphQLDTO request) {
        final EditarUsuarioCommand command =
                new EditarUsuarioCommand(
                        id,
                        request.nombre(),
                        request.email()
                );

        final Usuario usuario = this.editarUsuarioUseCase.ejecutar(command);

        return new UsuarioResponseGraphQLDTO(usuario.id().id(), usuario.nombre().nombre(), usuario.email().email());
    }

    @MutationMapping
    public boolean eliminarUsuario(UUID id) {
        this.eliminarUsuarioUseCase.ejecutar(id);
        return true;
    }

}
