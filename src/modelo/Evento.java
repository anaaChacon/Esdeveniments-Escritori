package modelo;

//import java.sql.Date;
import java.sql.Time;

import java.util.Date;

public class Evento {

  
    private String nombre;
    //Hora inicio
    private String fechaInicio;
    private Time horaInicio;
    
    //Hora fin
    private String fechaFin;
    private Time horaFin;
    
    private String descripcion;
    private String infoSecundaria;
    private String fotoMiniatura;
    private String fotoPrincipal;
    private int idCategoria;
    private int idLugar;
    private int idOrganizador;
  
    //Getters and setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaIniciFormateada) {
        this.fechaInicio = fechaIniciFormateada;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFinFormateada) {
        this.fechaFin = fechaFinFormateada;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getInfoSecundaria() {
        return infoSecundaria;
    }
    public void setInfoSecundaria(String infoSecundaria) {
        this.infoSecundaria = infoSecundaria;
    }
    public String getFotoMiniatura() {
        return fotoMiniatura;
    }
    public void setFotoMiniatura(String fotoMiniatura) {
        this.fotoMiniatura = fotoMiniatura;
    }
    public String getFotoPrincipal() {
        return fotoPrincipal;
    }
    public void setFotoPrincipal(String fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }
    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public int getIdLugar() {
        return idLugar;
    }
    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }
    public int getIdOrganizador() {
        return idOrganizador;
    }
    public void setIdOrganizador(int idOrganizador) {
        this.idOrganizador = idOrganizador;
    }
    public Time getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }
    public Time getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
    
    
    
}
