package Model;

public class Administrador {
    private String contraseña;

    public Administrador() {}

    public Administrador(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
