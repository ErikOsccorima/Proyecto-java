package Clases;

public class Administrador extends Empleado {

    public Administrador(String dni, String nombres, String apellidos,String login, String contrasenia, String rol) {
        super(dni, nombres, apellidos, login, contrasenia, rol);
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion();
    }
}