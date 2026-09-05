package es.tutoriales.hexagonal.usuarios.domain.model;

import java.util.UUID;

public class Usuario {

    private final UsuarioId id;
    private Nombre nombre;
    private Email email;

    private Usuario(
            UsuarioId id,
            Nombre nombre,
            Email email
    ) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public static Usuario crear(
            Nombre nombre,
            Email email
    ) {
        return new Usuario(
                UsuarioId.generar(),
                nombre,
                email
        );
    }

    public static Usuario reconstituir(
            UUID id,
            String nombre,
            String email) {
        return new Usuario(new UsuarioId(id), new Nombre(nombre), new Email(email));
    }

    public Usuario editar(String nombre, String email) {

        if (nombre != null) {
            this.nombre = new Nombre(nombre);
        }

        if (email != null) {
            this.email = new Email(email);
        }

        return this;
    }

    public UsuarioId id() {
        return id;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }
}
