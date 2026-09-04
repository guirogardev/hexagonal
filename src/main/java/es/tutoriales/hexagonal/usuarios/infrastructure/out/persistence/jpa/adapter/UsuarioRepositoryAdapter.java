package es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.adapter;

import es.tutoriales.hexagonal.usuarios.application.out.UsuarioRepository;
import es.tutoriales.hexagonal.usuarios.domain.model.Usuario;
import es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.entity.UsuarioEntity;
import es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.repository.UsuarioJpaRepository;

public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository repository;

    public UsuarioRepositoryAdapter(
            UsuarioJpaRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public void guardar(Usuario usuario) {

        final var entity = new UsuarioEntity(
                usuario.id().id(),
                usuario.nombre().nombre(),
                usuario.email().email()
        );

        repository.save(entity);
    }
}
