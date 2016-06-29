/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import org.sql2o.Sql2o;
/**
 *
 * @author hungnt
 */
public class Evn {
    private static Sql2o connection = null;
    private static Connection mysqlConnection = null;
    public static Sql2o getInstance(){
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/swing_pos";
        if(connection == null){
            try {
            connection = new Sql2o(url, userName, password);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    /**
     *
     * @return Connection
     */
    public static Connection getMysqlInstance(){
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/swing_pos";
        if(mysqlConnection == null){
            try {
            mysqlConnection = DriverManager.getConnection(url, userName, password);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mysqlConnection;
    }
    private Evn(){}
}
