package es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioJpaEntity, UUID> {
    boolean existsByNombre(String nombre);
    boolean existsByEmail(String email);
}
