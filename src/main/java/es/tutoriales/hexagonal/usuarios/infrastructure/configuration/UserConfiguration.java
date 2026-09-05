package es.tutoriales.hexagonal.usuarios.infrastructure.configuration;

import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioService;
import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.in.editar_usuario.EditarUsuarioService;
import es.tutoriales.hexagonal.usuarios.application.in.editar_usuario.EditarUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.out.UsuarioRepository;
import es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.UsuarioJpaRepository;
import es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.UsuarioPersistenceMapper;
import es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.UsuarioRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UsuarioRepository usuarioRepository(
            UsuarioJpaRepository repository,
            UsuarioPersistenceMapper mapper
    ) {
        return new UsuarioRepositoryAdapter(repository, mapper);
    }

    @Bean
    public CrearUsuarioUseCase crearUsuarioUseCase(
            UsuarioRepository usuarioRepository
    ) {
        return new CrearUsuarioService(usuarioRepository);
    }

    @Bean
    public EditarUsuarioUseCase editarUsuarioUseCase(
            UsuarioRepository usuarioRepository
    ) {
        return new EditarUsuarioService(usuarioRepository);
    }
}
