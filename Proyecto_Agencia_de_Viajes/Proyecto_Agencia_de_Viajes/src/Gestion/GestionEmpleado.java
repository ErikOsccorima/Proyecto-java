package Gestion;
import Clases.Empleado;
import Clases.Administrador;
import Clases.AsesorDeViaje;
import Clases.Imprimir;
import java.util.Scanner;
public class GestionEmpleado {
    private Empleado[] empleados;
    private int contador;
    private Scanner sc;
    public GestionEmpleado(int tamanio) {
        empleados = new Empleado[tamanio];
        contador = 0;
        sc = new Scanner(System.in);
    }
    // Registrar empleado
    public void registrarEmpleado() {
        if (contador >= empleados.length) {
            Imprimir.imprimir("No hay espacio para registrar empleados.");
            return;
        }
        Imprimir.imprimir("DNI:");
        String dni = sc.nextLine();

        Imprimir.imprimir("Nombres:");
        String nombres = sc.nextLine();

        Imprimir.imprimir("Apellidos:");
        String apellidos = sc.nextLine();

        Imprimir.imprimir("Usuario:");
        String login = sc.nextLine();

        Imprimir.imprimir("Contraseña:");
        String contrasenia = sc.nextLine();

        Imprimir.imprimir("Rol (Administrador, AsesorDeViaje):");
        String rol = sc.nextLine();
        Empleado empleado;
        if(rol.equalsIgnoreCase("Administrador")){
            empleado = new Administrador(dni,nombres,apellidos,login,contrasenia,rol);
        }else{
            empleado = new AsesorDeViaje(dni,nombres,apellidos,login,contrasenia,rol);
        }
        empleados[contador] = empleado;
        contador++;
        Imprimir.imprimir("Empleado registrado correctamente.");
    }
    
    
    public boolean agregarEmpleado(Empleado empleado) {

    if (contador >= empleados.length) {
        return false;
    }

    empleados[contador] = empleado;
    contador++;

    return true;
    }
    // Eliminar empleado
    public void eliminarEmpleado() {
        Imprimir.imprimir("Ingrese el DNI del empleado:");
        String dni = sc.nextLine();
        for (int i = 0; i < contador; i++) {
            if (empleados[i].getDni().equalsIgnoreCase(dni)) {
                for (int j = i; j < contador - 1; j++) {
                    empleados[j] = empleados[j + 1];
                }
                empleados[contador - 1] = null;
                contador--;
                Imprimir.imprimir("Empleado eliminado correctamente.");
                return;
            }
        }
        Imprimir.imprimir("Empleado no encontrado.");
    }
    // Mostrar empleados
    public void mostrarEmpleados(){
        if(contador == 0){
            Imprimir.imprimir("No hay empleados registrados.");
            return;
        }
        for(int i = 0; i < contador; i++){
            Imprimir.imprimir(empleados[i].mostrarInformacion());
            Imprimir.imprimir("-------------------------");

        }
    }
    public boolean eliminarEmpleado(String dni) {
    for(int i = 0; i < contador; i++){
        if(empleados[i].getDni().equalsIgnoreCase(dni)){
            for(int j = i; j < contador - 1; j++){
                empleados[j] = empleados[j + 1];
            }
            empleados[contador - 1] = null;
            contador--;
            return true;
        }
    }

    return false;
}
    public boolean modificarEmpleado(String dni,String nombres,String apellidos,String usuario,String contrasenia,String rol){

    for(int i = 0; i < contador; i++){

        if(empleados[i].getDni().equalsIgnoreCase(dni)){

            empleados[i].setNombres(nombres);
            empleados[i].setApellidos(apellidos);
            empleados[i].setLogin(usuario);
            empleados[i].setContrasenia(contrasenia);
            empleados[i].setRol(rol);

            return true;
        }
    }

    return false;
}
}