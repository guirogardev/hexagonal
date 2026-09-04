package es.tutoriales.hexagonal.usuarios.infrastructure.configuration;

import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioService;
import es.tutoriales.hexagonal.usuarios.application.in.crear_usuario.CrearUsuarioUseCase;
import es.tutoriales.hexagonal.usuarios.application.out.UsuarioRepository;
import es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.adapter.UsuarioRepositoryAdapter;
import es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.repository.UsuarioJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UsuarioRepository usuarioRepository(
            UsuarioJpaRepository repository
    ) {
        return new UsuarioRepositoryAdapter(repository);
    }

    @Bean
    public CrearUsuarioUseCase crearUsuarioUseCase(
            UsuarioRepository usuarioRepository
    ) {
        return new CrearUsuarioService(usuarioRepository);
    }
}
