package conexion;

import java.sql.*;


/**
 * Clase que permite conectar con la base de datos
 * @author jrsimo
 *
 */
public class Conexion {
   static String bd = "qxm773";
   static String login = "root";//admin
   static String password = "";//Lesron1
   static String url = "jdbc:mysql://127.0.0.1/"+bd;//127.0.0.1:3306 - 84.123.121.34:8080 - 84.123.121.34

   Connection conn = null;

   /** Constructor de DbConnection */
   public Conexion() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
           // System.out.println("Conección a base de datos "+bd+" OK");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }

}