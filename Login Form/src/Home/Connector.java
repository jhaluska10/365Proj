/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jhalu
 */
public class Connector {
    private static Connection connect = null;
    
    public static Connection getInstance() {
        if (connect == null) {
            try {
                connect = genConnection();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        assert connect != null;
        return connect;
    }
    
    private static Connection genConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://ambari-node5.csc.calpoly.edu:3306/bbjgroup?user=bbjgroup&password=123pass");
    }

    /**
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    /*public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://ambari-node5.csc.calpoly.edu:3306/bbjgroup?user=bbjgroup&password=123pass");
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("Select * from customers");
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        }catch (ClassNotFoundException e){
            
        }
        
    }*/
}
