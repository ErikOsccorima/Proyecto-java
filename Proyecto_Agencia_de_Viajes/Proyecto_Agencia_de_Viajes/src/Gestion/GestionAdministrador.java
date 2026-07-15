package Gestion;
import Clases.Empleado;
public class GestionAdministrador {
    private Empleado[] empleados;
    private int contador;
    public GestionAdministrador(int capacidad){
        empleados = new Empleado[capacidad];
        contador = 0;
    } 
    // registrar empleado
    public void registrarEmpleado(Empleado p){
        if(contador<empleados.length){
            empleados[contador]=p;
            contador++;
            imprimir("Empleado registrado correctamente.");
        }else{
            imprimir("No hay espacio para registrar mas empleados.");
        }
    } 
    //buscar empleado por DNI
    public Empleado buscarEmpleado(String dni){
        for (int i = 0; i < contador; i++) {
            if(empleados[i].getDni().equals(dni)){
                return empleados[i];
            }
        }
        return null; 
    }
    public void eliminarEmpleado(String dni){
        for (int i = 0; i < contador; i++) {
            if(empleados[i].getDni().equals(dni)){
                for (int j = i; j < contador; j++) {
                    empleados[j] = empleados[j+1];
                }
                empleados[contador-1]=null;
                contador--;
                imprimir("Empleado eliminado con exito.");
                return;
            }
        }
        imprimir("Empleado no encontrado");
    }    
    public void mostrarEmpleados(){
        if(contador==0){
            imprimir("No hay empleados registrados");
            return;
        }
        for (int i = 0; i < contador; i++) {
            imprimir("INFORMACION");
            imprimir(empleados[i].mostrarInformacion());
            imprimir("___________________________________________________________________-");
        }
    }
    public static void imprimir(String cadena){
        System.out.println(cadena);
    }
}