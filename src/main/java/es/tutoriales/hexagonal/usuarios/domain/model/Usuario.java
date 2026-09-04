package es.tutoriales.hexagonal.usuarios.domain.model;

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

    public void cambiarEmail(String email) {
        this.email = new Email(email);
    }

    public void cambiarNombre(String nombre) {
        this.nombre = new Nombre(nombre);
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
