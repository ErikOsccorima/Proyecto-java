package Clases;
public abstract class Empleado {
    private String dni, nombres, apellidos, login, contrasenia, rol;
    public Empleado(String dni, String nombres, String apellidos, String login, String contrasenia, String rol) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.login = login;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String mostrarInformacion(){
        return "INFORMACION DEL COLABORADOR"+
                "\nDNI: "+dni+
                "\nNombres: "+nombres+
                "\nApellidos: "+apellidos+
                "\nUsuario: "+login+
                "\nRol: "+ rol;
    }
     
    
}
