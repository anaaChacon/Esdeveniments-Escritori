package conexion;
import java.sql.*;

public class Conexion {
   static String bd = "qxm773";//u468011279_event
   static String login = "admin";//admin, root,u468011279_ana
   static String password = "Lesron1";//Lesron1, 
   static String url = "jdbc:mysql://127.0.0.1/"+bd;//127.0.0.1:3306 - 84.123.121.34:8080 - 84.123.121.34 - mysql.hostinger.es

   Connection conn = null;

   public Conexion() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
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