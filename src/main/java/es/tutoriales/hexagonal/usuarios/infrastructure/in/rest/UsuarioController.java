package es.tutoriales.hexagonal.usuarios.infrastructure.in.rest;

import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioCommand;
import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.editar_usuario.EditarUsuarioCommand;
import es.tutoriales.hexagonal.usuarios.application.in.editar_usuario.EditarUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.eliminar_usuario.EliminarUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.obtener_usuario.ObtenerUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UsuariosApi;
import org.openapitools.model.CrearUsuarioRequest;
import org.openapitools.model.EditarUsuarioRequest;
import org.openapitools.model.UsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UsuarioController implements UsuariosApi {

    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final EditarUsuarioUseCase editarUsuarioUseCase;
    private final ObtenerUsuarioUseCase obtenerUsuarioUseCase;
    private final EliminarUsuarioUseCase eliminarUsuarioUseCase;

    @Override
    public ResponseEntity<UsuarioResponse> obtenerUsuario(UUID id) {
        final Usuario usuario = this.obtenerUsuarioUseCase.ejecutar(id);

        return ResponseEntity.ok(
                new UsuarioResponse()
                        .id(usuario.id().id())
                        .nombre(usuario.nombre().nombre())
                        .email(usuario.email().email())
        );
    }

    @Override
    public ResponseEntity<UsuarioResponse> crearUsuario(CrearUsuarioRequest request) {

        final CrearUsuarioCommand command = new es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioCommand(
                request.getNombre(),
                request.getEmail()
        );

        this.crearUsuarioUseCase.ejecutar(command);

        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<UsuarioResponse> editarUsuario(
            UUID id,
            EditarUsuarioRequest request) {
        final EditarUsuarioCommand command =
                new EditarUsuarioCommand(
                        id,
                        request.getNombre(),
                        request.getEmail()
                );

        final Usuario usuario = this.editarUsuarioUseCase.ejecutar(command);

        return ResponseEntity.ok(
                new UsuarioResponse()
                        .id(usuario.id().id())
                        .nombre(usuario.nombre().nombre())
                        .email(usuario.email().email())
        );
    }

    @Override
    public ResponseEntity<Void> eliminarUsuario(UUID id) {
        this.eliminarUsuarioUseCase.ejecutar(id);
        return ResponseEntity.noContent().build();
    }
}
