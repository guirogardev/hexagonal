package es.tutoriales.hexagonal.usuarios.infrastructure.in.grpc;

import es.tutoriales.hexagonal.usuarios.application.in.obtener_usuario.ObtenerUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
@RequiredArgsConstructor
public class UsuariosGRPC extends UserServiceGrpc.UserServiceImplBase {

    private final ObtenerUsuarioUseCase obtenerUsuarioUseCase;

    @Override
    public void getUser(
            GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {

        final UUID id = UUID.fromString(request.getId());

        final Usuario usuario = this.obtenerUsuarioUseCase.ejecutar(id);

        final User user = User.newBuilder()
                .setId(usuario.id().id().toString())
                .setName(usuario.nombre().nombre())
                .setEmail(usuario.email().email())
                .build();

        final GetUserResponse response = GetUserResponse.newBuilder()
                .setUser(user)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
