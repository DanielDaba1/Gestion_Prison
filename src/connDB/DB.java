/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connDB;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Daniel
 */
public class DB {
    static Connection conn;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/prison";
    static String uname = "root";
    static String pass = "@Nsimire1";
    
    public static Connection getConnection() throws Exception{
        if(conn == null){
        conn = DriverManager.getConnection(url, uname, pass);
        }
        return conn;
    
    }
}
