package es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.repository;

import es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, UUID> {
}
