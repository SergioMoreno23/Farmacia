/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySql;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */

public class conexion {
    private static Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/farmaciajor";

    public conexion() {
         con=null;
        try{
            Class.forName(driver);
          
            con= (Connection) DriverManager.getConnection(url, user, pass);  
           
        }        
        catch (ClassNotFoundException | SQLException e){
            
          JOptionPane.showMessageDialog(null,"CONECCIÓN NO ESTABLECIDA");
        }
    }


  
    public Connection getConnection (){
        return con;
    }
    public void desconectar (){
        con= null; 
        }
}
