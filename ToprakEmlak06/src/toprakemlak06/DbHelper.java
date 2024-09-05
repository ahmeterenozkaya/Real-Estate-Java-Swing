/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toprakemlak06;
import java.sql.*;

/**
 *
 * @author ozkay
 */
public class DbHelper {
    private String userName = "emlakdbb";
    private String password = "191006Ee..!?";
    private String dbUrl = "jdbc:postgresql://musti.uk:5439/emlakdbb";

    public Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(dbUrl,userName,password);
    }
    public void showErrorMessage(SQLException exception){
    System.out.println("Error : " + exception.getMessage());
        System.out.println("Error code : " + exception.getErrorCode());
        
    }
    
}
