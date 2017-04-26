package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import conexion.Conexion;
import modelo.Evento;


public class MetodosBaseDeDatos {
    
    	//Create method for date system date
  	public static String dateToMySQLDate(int anyo, int mes, int dia){
  	    
  	    	String fecha;
  	    
  	    	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new GregorianCalendar(anyo, mes - 1, dia).getTime();
		fecha = formato.format(date.getTime());
		
  		return formato.format(fecha);
  	}
  	
    
    //Metodo para añadir un evento
    public static void anyadirEvento(Evento evento) {
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	//bloque try - catch
	try {
	    
	    	//Parsear el dia, mes y año a tipo date
	    	//String fechaInicio = dateToMySQLDate(evento.getAnyoInicio(), evento.getMesInicio(), evento.getDiaInicio());
	    	
	    	//Realizar la inserción
		Statement insercionEvento = conex.getConnection().createStatement();
		insercionEvento.executeUpdate("INSERT INTO eventos(nombre, fecha_inicio, hora_inicio, fecha_fin, hora_fin, descripcion, info_secundaria, foto_miniatura, foto_principal, idCategoria, idLugar, idOrganizador)"
			+ " VALUES ('"
				+ evento.getNombre() + "', '"
				+ evento.getFechaInicio() + "', '"
				+ evento.getHoraInicio() + "', '"
				+ evento.getFechaFin() + "', '"
				+ evento.getHoraFin() + "', '"
				+ evento.getDescripcion() + "', '"
				+ evento.getInfoSecundaria() + "', '"
				+ evento.getFotoMiniatura() + "', '"
				+ evento.getFotoPrincipal() + "', '"
				+ evento.getIdCategoria() + "', '"
				+ evento.getIdLugar() + "', '"
				+ evento.getIdOrganizador() + "')");
		
		JOptionPane.showMessageDialog(null,"Se ha registrado correctamente el evento", "Información",JOptionPane.INFORMATION_MESSAGE);
		insercionEvento.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"Añadir evento No se Registro, verifique la consola para ver el error","Error", JOptionPane.ERROR_MESSAGE);
	}
    }
    
  //Metodo para modificar un evento
    public static void modificarEvento(Evento evento, String nombre) {
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	//bloque try - catch
	try {
	    	//Realizar la inserción
		Statement insercionEvento = conex.getConnection().createStatement();
		insercionEvento.executeUpdate("UPDATE eventos SET nombre = '"+evento.getNombre()+"',"
			+ " fecha_inicio = '"+evento.getFechaInicio()+"',"
			+ " hora_inicio = '"+evento.getHoraInicio()+"',"
			+ " fecha_fin = '"+evento.getFechaFin()+"',"
			+ " hora_fin = '"+evento.getHoraFin()+"',"
			+ " descripcion = '"+evento.getDescripcion()+"',"
			+ " info_secundaria = '"+evento.getInfoSecundaria()+"',"
			+ " foto_miniatura = '"+evento.getFotoMiniatura()+"',"
			+ " foto_principal = '"+evento.getFotoPrincipal()+"',"
			+ " idCategoria = '"+evento.getIdCategoria()+"',"
			+ " idLugar = '"+evento.getIdLugar()+"',"
			+ " idOrganizador = '"+evento.getIdOrganizador()+"'"
			+ " WHERE nombre = '"+nombre+"';");
		
		JOptionPane.showMessageDialog(null,"Se ha modificado correctamente el evento", "Información",JOptionPane.INFORMATION_MESSAGE);
		insercionEvento.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"No se ha modificado el evento, verifique la consola para ver el error","Error", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    //Metodo consultar evento donde el nombre sea igual a otro
    public static Evento consultarEventoMarcado(String nombreEvento){
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	
	//Declaro un arrayList de tipo String
	Evento evento = new Evento();
	
	//bloque try - catch
	try {
	    Statement mostrarEvento = conex.getConnection().createStatement();
	    ResultSet rs = mostrarEvento.executeQuery("SELECT * FROM eventos WHERE nombre = '"+nombreEvento+"';");
			    
		 while(rs.next()){
		     evento.setNombre(String.valueOf(rs.getObject("nombre")));
		     evento.setFechaInicio(String.valueOf(rs.getObject("fecha_inicio")));
		     evento.setHoraInicio(Time.valueOf(String.valueOf(rs.getObject("hora_inicio"))));
		     evento.setFechaFin(String.valueOf(rs.getObject("fecha_fin")));
		     evento.setHoraFin(Time.valueOf(String.valueOf(rs.getObject("hora_fin"))));
		     evento.setDescripcion(String.valueOf(rs.getObject("descripcion")));
		     evento.setInfoSecundaria(String.valueOf(rs.getObject("info_secundaria")));
		     evento.setFotoMiniatura(String.valueOf(rs.getObject("foto_miniatura")));
		     evento.setFotoPrincipal(String.valueOf(rs.getObject("foto_principal")));
		     evento.setIdCategoria(Integer.parseInt(String.valueOf(rs.getObject("idCategoria"))));
		     evento.setIdLugar(Integer.parseInt(String.valueOf(rs.getObject("idLugar"))));
		     evento.setIdOrganizador(Integer.parseInt(String.valueOf(rs.getObject("idOrganizador"))));
		}
			    
		 rs.close();
		 mostrarEvento.close();
		 conex.desconectar();
			    
	} catch (SQLException e) {
		System.out.println(e.getMessage());
				
	}
	
	
	return evento;
    }
    
    public static Vector<String> consultarNombreEventos(){
	
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
		Conexion conex = new Conexion();
		
		//Declaramos un arrayList de string
		Vector<String> arrayEventos = new Vector<String>();
		
		//bloque try - catch
		try {
		    Statement mostrarNombreEventos = conex.getConnection().createStatement();
		    ResultSet rs = mostrarNombreEventos.executeQuery("SELECT * FROM eventos"
		    	+ " WHERE CONCAT(fecha_fin, ' ', hora_fin) > sysdate()"
		    	+ " ORDER BY CONCAT(fecha_fin, ' ', hora_fin );");
		    
		    while(rs.next()){
			arrayEventos.add(String.valueOf(rs.getObject("nombre")));
		    }
		    
		    rs.close();
		    mostrarNombreEventos.close();
		    conex.desconectar();
		    
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		
	return arrayEventos;
    }
    
    //Método consultar todas las categorias
    public static ArrayList<String> consultarCategorias(){
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	
	//Creamos un arrayList de tipo String
	ArrayList<String>arrayCategorias = new ArrayList<String>();
	
	//bloque try - catch
	try {
	    Statement mostrarCategorias = conex.getConnection().createStatement();
	    ResultSet rs = mostrarCategorias.executeQuery("SELECT * FROM categorias;");
	    
	    while(rs.next()){
		arrayCategorias.add(String.valueOf(rs.getObject("nombre")));
	    }
	    
	    rs.close();
	    mostrarCategorias.close();
	    conex.desconectar();
		    
	
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	    JOptionPane.showMessageDialog(null,"Consultar categorias No se Registro, verifique la consola para ver el error","Error", JOptionPane.ERROR_MESSAGE);
	}
	
	return arrayCategorias;
    }
    
    //Metodo que nos devuleva la id de una categoria
    public static int consultarIdCategorias(String nombreCategoria){
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	
	//creamos una variable para recoger la id
	int idCategoria = 0;
	
	//bloque try - catch
	try {
	    Statement mostrarIdCategorias = conex.getConnection().createStatement();
	    ResultSet rs = mostrarIdCategorias.executeQuery("SELECT * FROM categorias WHERE nombre = '"+nombreCategoria+"';");
	    
	    while(rs.next()){
		idCategoria = (int) rs.getObject("id_categoria");
	    }
		    
	    rs.close();
	    mostrarIdCategorias.close();
	    conex.desconectar();
	
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	    JOptionPane.showMessageDialog(null,"Consultar id Categoria No se Registro, verifique la consola para ver el error","Error", JOptionPane.ERROR_MESSAGE);
	}
	
	return idCategoria;
    }
    
    //Metodo para insertar un lugar
    public static void anyadirLugar(String nombreEvento) {
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	//bloque try - catch
	try {
	    
	    	//Realizar la inserción
		Statement insercionEvento = conex.getConnection().createStatement();//, direccion, horario, coor_latitud, coor_longitud, informacion, imagen
		insercionEvento.executeUpdate("INSERT INTO lugares(nombre)"
			+ " VALUES ('" + nombreEvento + "')");//, 'C/Prueba', '23:00', 23.5, 26.8, 'Informacion de prueba', 'prueba prueba'
		
		//JOptionPane.showMessageDialog(null,"Se ha registrado Exitosamente", "Información",JOptionPane.INFORMATION_MESSAGE);
		insercionEvento.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"Añadir lugar No se Registro, verifique la consola para ver el error","Error", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    //Metodo para sacar la id del evento
    	public static int consultarIdLugar(String nombreLugar){
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	
	//creamos una variable para recoger la id
	int idLugar = 0;
	
	//bloque try - catch
	try {
	    Statement mostrarCategorias = conex.getConnection().createStatement();
	    ResultSet rs = mostrarCategorias.executeQuery("SELECT * FROM lugares WHERE nombre = '"+nombreLugar+"';");
	    
	    while(rs.next()){
		idLugar = (int) rs.getObject("id_lugar");
	    }
	    
	    rs.close();
	    mostrarCategorias.close();    
	    conex.desconectar();
	
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	    JOptionPane.showMessageDialog(null,"Consultar id del lugar No se Registro, verifique la consola para ver el error","Error", JOptionPane.ERROR_MESSAGE);
	}
	
	return idLugar;
    }
    	
    	//Metodo para sacar la id del evento
    	public static String consultarNombreLugar(int idLugar){
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	
	//creamos una variable para recoger la id
	String nombreLugar = null;
	
	//bloque try - catch
	try {
	    Statement mostrarCategorias = conex.getConnection().createStatement();
	    ResultSet rs = mostrarCategorias.executeQuery("SELECT * FROM lugares WHERE id_lugar = '"+idLugar+"';");
	    
	    while(rs.next()){
		nombreLugar = String.valueOf(rs.getObject("nombre"));
	    }
	    
	    rs.close();
	    mostrarCategorias.close();    
	    conex.desconectar();
	
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	  
	}
	
	return nombreLugar;
    }
    	
    	
    	
    	//Metodo para sacar la id del organizador
    	public static int consultarIdOrganizador(String nombreOrganizador){
	//Instanciamos la clase Conexion para establecer la conexión a la base de datos
	Conexion conex = new Conexion();
	
	//creamos una variable para recoger la id
	int idOrganizador = 0;
	
	//bloque try - catch
	try {
	    Statement mostrarCategorias = conex.getConnection().createStatement();
	    ResultSet rs = mostrarCategorias.executeQuery("SELECT * FROM organizadores  WHERE nombre = '"+nombreOrganizador+"';");
	    
	    while(rs.next()){
		idOrganizador = (int) rs.getObject("id_organizador");
	    }
		 
	    rs.close();
	    mostrarCategorias.close();
	    conex.desconectar();
	    
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	    JOptionPane.showMessageDialog(null,"Consultar id Organizador No se Registro, verifique la consola para ver el error","Error", JOptionPane.ERROR_MESSAGE);
	}
	
	return idOrganizador;
    }
    	
    	public static void eliminarEvento(String nombreEvento){
    	    //Instanciamos la clase Conexion para establecer la conexión a la base de datos
    	    Conexion conex = new Conexion();
    	    
    	    //bloque try - catch
    	    try {
    		Statement eliminarEventoSeleccionado = conex.getConnection().createStatement();
    		
    		eliminarEventoSeleccionado.executeUpdate("DELETE FROM eventos WHERE nombre = '"+nombreEvento+"';");
    		
    		eliminarEventoSeleccionado.close();
    		conex.desconectar();
    		
    	    } catch (SQLException e) {
    		System.out.println(e.getMessage());
	    
	}
    	    
    	}
    

}
