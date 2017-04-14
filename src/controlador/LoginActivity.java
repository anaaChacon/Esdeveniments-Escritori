package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginActivity {
    
    public static String comprarLogin(String user, String password){
	
	//boolean datosCorrectos = false;
	String nombre = null;
	
	if(user.isEmpty() || password.isEmpty()){
	    JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    //datosCorrectos = false;
	}
	
	if(!user.isEmpty() && !password.isEmpty()){
	    
	//Realize one try-catch	
	try{	
	    //Connection with database
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/qxm773", "root", "campus");
	    
	    System.out.print("Conexión realizada...");
	    //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/qxm773", "qxm773", "cWCUNRwG85");			
	    Statement st = conexion.createStatement();
	    
	    //Realize other consult for organizators
	    ResultSet rs = st.executeQuery("SELECT *"
				+ " FROM organizadores"
				+ " WHERE username = '"+user+"'"
				+ " AND password = '"+password+"';");
	    
	    //if exist dates of user save this date on variables of type String
	    if(rs.next()){
		
		rs.first();
	    
		String usuario = rs.getString(2);
		String contrasenya = rs.getString(3);
		nombre = rs.getString(4);
	    
		System.out.println("\nUsuario: " + usuario + "\nContraseña: " + contrasenya);
		//datosCorrectos = true;
	    
	    }
	    else{
		JOptionPane.showMessageDialog(null, "Los datos no son correctos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		//datosCorrectos = false;
	    }
	    
	    
	    rs.close();
	    st.close();
	    
	}catch(SQLException ex){
		System.out.println("Error de mySQL");
		ex.printStackTrace();

	}catch(Exception e){
		e.printStackTrace();
	}
     }
	
	//return datosCorrectos;
	return nombre;
    }

}
