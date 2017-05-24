package modelo;

public class Lugar {

    private int id_lugar;
    private String nombreLugar, direccion, informacion, imagen;
    private double coor_latitud, coor_longitud;
    public int getId_lugar() {
        return id_lugar;
    }
    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }
    public String getNombreLugar() {
        return nombreLugar;
    }
    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getInformacion() {
        return informacion;
    }
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public double getCoor_latitud() {
        return coor_latitud;
    }
    public void setCoor_latitud(double coor_latitud) {
        this.coor_latitud = coor_latitud;
    }
    public double getCoor_longitud() {
        return coor_longitud;
    }
    public void setCoor_longitud(double coor_longitud) {
        this.coor_longitud = coor_longitud;
    }
    
    
}
