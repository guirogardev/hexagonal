package es.tutoriales.hexagonal.usuarios.infrastructure.in.rest.usuario;


import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioCommand;
import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioUseCase;
import org.openapitools.api.UsuariosApi;
import org.openapitools.model.CrearUsuarioRequest;
import org.openapitools.model.UsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController implements UsuariosApi {

    private final CrearUsuarioUseCase crearUsuarioUseCase;

    public UsuarioController(CrearUsuarioUseCase crearUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
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
}
