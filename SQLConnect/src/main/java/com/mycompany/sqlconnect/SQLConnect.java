/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.sqlconnect;

/**
 *
 * @author Student
 */
public class SQLConnect {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ConnectSQLClass con = ConnectSQLClass.getinstance();
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "POSTGRES";
        var name = "my_table";
        
        String[][] rows = {{"25", "'rtyy'", "'ert'"}, {"34", "'tgtg'", "'34'"}, {"432", "'fdgdf'", "'dfgdf'"}};
        con.connect(url, user, pass);

        var arr = new String[3];
        arr[0] = "v_id int,PRIMARY KEY";
        arr[1] = "v_name text";
        arr[2] = "potato varchar(10)";
        if (con.create(name, arr)) {
            System.out.print("YES");
        }
        if (con.insert(name, rows) != -1) {
            System.out.print("INSERTED");
        }

    }

}
