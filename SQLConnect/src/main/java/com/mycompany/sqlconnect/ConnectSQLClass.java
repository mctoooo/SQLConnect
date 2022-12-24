/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sqlconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Student
 */
public class ConnectSQLClass implements ISQL {
    
    private Connection conn;
private static ConnectSQLClass instanse;
     private   ConnectSQLClass(){
        }
     
    @Override
    public boolean connect(String url, String username, String password) {
        
        try {
            this.conn = DriverManager.getConnection(url, username, password);
            return true;
        } catch (SQLException ex) {
            this.conn=null;
            return false;
        }
        
    }

    @Override
    public void close() throws Exception {
  if (conn!= null){
  conn.close();
  }
  }
    public static ConnectSQLClass getinstance(){
    if (instanse == null) instanse = new ConnectSQLClass();
    return instanse;
    }
    
}