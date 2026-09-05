package es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa;

import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPersistenceMapper {

    public Usuario toDomain(UsuarioJpaEntity entity) {
        return Usuario.reconstituir(
                entity.getId(),
                entity.getNombre(),
                entity.getEmail()
        );
    }

    public UsuarioJpaEntity toEntity(Usuario usuario) {
        return new UsuarioJpaEntity(
                usuario.id().id(),
                usuario.nombre().nombre(),
                usuario.email().email()
        );
    }
}
