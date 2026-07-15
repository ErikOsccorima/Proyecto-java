package Clases;
public class DestinoTuristico {
    private String nombre, pais, ciudad, descripcion, clima, idioma, imagen;
    public DestinoTuristico(String nombre, String pais, String ciudad, String descripcion, String clima, String idioma, String imagen) {
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.clima = clima;
        this.idioma = idioma;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String mostrarDatos(){
        return "Nombre: "+nombre+
                "\nPais: "+pais+
                "\nCiudad: "+ciudad+
                "\nDescripcion: "+descripcion+
                "\nClima: "+clima+
                "\nIdioma: "+idioma+
                "\nImagen: "+imagen;           
    }
}
