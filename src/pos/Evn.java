/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import static org.jooq.impl.DSL.*;
import java.sql.*;

/**
 *
 * @author hungnt
 */
public class Evn {
    private static Connection connection = null;
    public static Connection getInstance(){
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/swing_pos";
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, userName, password);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    private Evn(){}
}
