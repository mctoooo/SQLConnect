/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sqlconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.LinkedList;

/**
 *
 * @author Student
 */
public class ConnectSQLClass implements ISQL {

    private Connection conn;
    private Statement stm;
    private static ConnectSQLClass instanse;

    private ConnectSQLClass() {
    }

    @Override
    public boolean connect(String url, String username, String password) {

        try {
            this.conn = DriverManager.getConnection(url, username, password);
            stm = conn.createStatement();
            return true;
        } catch (SQLException ex) {
            this.conn = null;
            stm = null;
            return false;
        }

    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

    public static ConnectSQLClass getinstance() {
        if (instanse == null) {
            instanse = new ConnectSQLClass();
        }
        return instanse;
    }

    @Override
    public boolean create(String tableName, String[] columns) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTs " + tableName + "(";
            for (String column : columns) {
                sql += column + ',';
            }
            sql = sql.substring(0, sql.length() - 1);
            sql += ");";
            
            stm.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int insert(String tableName, String[][] rows) {
        try {
            String ins = "INSERT INTO " + tableName + " VALUES";
            for (String[] row : rows) {
                ins += "(";
                for (String str : row) {
                    ins += str + ',';
                }
                ins = ins.substring(0, ins.length() - 1);
                ins += "),";
            }
            ins = ins.substring(0, ins.length() - 1);
            ins += ";";
            System.out.print(ins);
            return stm.executeUpdate(ins);

        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public LinkedList<String> select(String tableName, String[] columns) {
        LinkedList<String> list = new LinkedList<String>();
        try {

            String sel = "";

            for (String col : columns) {
                sel += col + ',';
            }
            sel = sel.substring(-2);
            sel += "FROM " + tableName + ';';

            ResultSet rs = stm.executeQuery(sel);
            String res = "";
            while (rs.next()) {
                int i = 1;
                res += rs.getString(i) + ',';
                list.add(res);
                i++;

            }
            return list;
        } catch (Exception e) {
            return list;

        }

    }

    @Override
    public int updateRows(String tableName, String column, String conditionColumn, String[] conditions, String[] values) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateColumns(String tableName, String[] columns, String[] values, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String tableName) {
       try{
        String del = "DELITE TABLE" + tableName + ';';
        return stm.execute(del);
       } catch (Exception e) {
           return false;
       }
    }

    @Override
    public int deleteRows(String tableName, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addColumn(String tableName, String column) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
