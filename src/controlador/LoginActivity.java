package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import conexion.Conexion;

public class LoginActivity {
    
    public static String comprarLogin(String user, String password){
	
	String nombre = null;
	
	if(user.isEmpty() || password.isEmpty()){
	    JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	if(!user.isEmpty() && !password.isEmpty()){
	    
	//Realize one try-catch	
	try{	
	  //Instanciamos la clase Conexion para establecer la conexión a la base de datos
	    Conexion conex = new Conexion();			
	    Statement st = conex.getConnection().createStatement();
	    
	    //Realize other consult for organizators
	    ResultSet rs = st.executeQuery("SELECT *"
				+ " FROM organizadores"
				+ " WHERE username = '"+user+"'"
				+ " AND password = '"+password+"';");
	    
	    //if exist dates of user save this date on variables of type String
	    if(rs.next()){
		
		rs.first();
		nombre = rs.getString(4);
	    }
	    else{
		JOptionPane.showMessageDialog(null, "Los datos no son correctos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    }
	    
	    rs.close();
	    st.close();
	    conex.desconectar();
	    
	}catch(SQLException ex){
		System.out.println("Error de mySQL");
		ex.printStackTrace();

	}catch(Exception e){
		e.printStackTrace();
	}
     }
	
	//return name;
	return nombre;
    }

}
