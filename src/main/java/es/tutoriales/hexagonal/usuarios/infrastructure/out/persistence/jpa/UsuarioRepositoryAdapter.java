package es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa;

import es.tutoriales.hexagonal.usuarios.application.out.UsuarioRepository;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository repository;
    private final UsuarioPersistenceMapper mapper;

    @Override
    public void guardar(Usuario usuario) {

        final UsuarioJpaEntity entity = new UsuarioJpaEntity(
                usuario.id().id(),
                usuario.nombre().nombre(),
                usuario.email().email()
        );

        this.repository.save(entity);
    }

    @Override
    public Optional<Usuario> getById(UUID id) {
        final Optional<Usuario> resultado;
        final Optional<UsuarioJpaEntity> entityOpt = this.repository.findById(id);

        if (entityOpt.isPresent()) {
            resultado = Optional.of(this.mapper.toDomain(entityOpt.get()));
        } else {
            resultado = Optional.empty();
        }
        return resultado;
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return this.repository.existsByNombre(nombre);
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.repository.existsByEmail(email);
    }
}
