package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity {
    
    public static boolean comprarLogin(String user, String password){
	
	boolean datosCorrectos = false;
	
	//Realize one try-catch	
	try{	
	    //Connection with database
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/qxm773", "qxm773", "Lesron1");
	    
	    System.out.print("Conexión realizada...");
	    //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/qxm773", "qxm773", "cWCUNRwG85");			
	    Statement st = conexion.createStatement();
	    
	    //Realize other consult for books
	    ResultSet rs = st.executeQuery("SELECT username, password"
				+ " FROM usuarios"
				+ " WHERE username = '"+user+"'"
				+ " AND password = '"+password+"';");
	    
	    rs.first();
	    
	    String usuario = rs.getString(1);
	    String contrasenya = rs.getString(2);
	    
	    if(usuario != null && contrasenya != null){
		datosCorrectos = true;
	    }
	    else{
		datosCorrectos = false;
	    }
	    
	    
	    rs.close();
	    st.close();
	    
	}catch(SQLException ex){
		System.out.println("Error de mySQL");
		ex.printStackTrace();

	}catch(Exception e){
		e.printStackTrace();
	}
	
	return datosCorrectos;
    }

}
