package es.tutoriales.hexagonal.usuarios.infrastructure.out.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UsuarioJpaEntity {
    @Id
    private UUID id;
    private String nombre;
    private String email;
}
