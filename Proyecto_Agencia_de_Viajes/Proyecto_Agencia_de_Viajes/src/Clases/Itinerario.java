package Clases;
public class Itinerario {
    private int dia;
    private String descripcionActividad;
    public Itinerario(int dia, String descripcionActividad) {
        this.dia = dia;
        this.descripcionActividad = descripcionActividad;
    }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public String mostrarInformacion() {
        return "Día " + dia + ": " + descripcionActividad;
    }
}