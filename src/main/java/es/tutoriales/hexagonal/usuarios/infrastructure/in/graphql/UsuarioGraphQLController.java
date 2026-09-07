package es.tutoriales.hexagonal.usuarios.infrastructure.in.graphql;

import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.editar_usuario.EditarUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.eliminar_usuario.EliminarUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.obtener_usuario.ObtenerUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
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

}
