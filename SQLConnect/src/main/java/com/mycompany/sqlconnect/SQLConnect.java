/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.sqlconnect;

import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class SQLConnect {

    public static void main(String[] args) throws Exception {

        ConnectSQLClass con = ConnectSQLClass.getinstance();

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "postgres";
        var name = "my_table";
        var condition = "v_id=25";
        var col4 = "cucumber text";

        String[][] rows = {{"25", "'rtyy'", "'ert'"}, {"34", "'tgtg'", "'34'"}, {"432", "'fdgdf'", "'dfgdf'"}};
        con.connect(url, user, pass);

        var arr = new String[3];
        arr[0] = "v_id SERIAL";
        arr[1] = "v_name text";
        arr[2] = "potato varchar(10)";
        

        if (con.create(name, arr)) {
            System.out.println("YES,con create.");
        }
//        if (con.insert(name, rows) != -1) {
//            System.out.println("INSERTED");
//        }

 //      con.addColumn(name, col4);

//       String[] vall = {"foring"};
//        String[] coll4 = {"cucumber"};
//        condition = "cucumber is NULL";
//        con.updateColumns(name, coll4, vall, condition);
//      String[] vall = {"no bed", "35"};
//      condition = "cucumber='foring'";
//        con.updateColumns(name, coll4, vall, condition);
//        condition = "v_id=432";
  /*      String[] coll4 = {"cucumber", "potato"};
        String[] vall = {"foring", "Egypt"};
        con.updateColumns(name, coll4, vall, condition);
        String[][] rowsS = {{"26", "'rtyy'", "'ert'", "'black'"}, {"36", "'tgtg'", "'34'", "'wite'"}, {"4232", "'fdgdf'", "'dfgdf'", "'green'"}};
        con.insert(name, rowsS);
        if (con.deleteRows(name, condition) != -1) {
            System.out.println("ROWS DELETED");
        }
*/
//        condition = "v_id";
//        if (con.PrimaryKey(name, condition)) {
//           System.out.println(" -PK- ");
//        }
//     condition ="potato";
//     var col="v_name";
//     String[] args1={"tgtg","rtyy"};
//     String[] args2={"smoll","big"};     
//    con.updateRows(name, col, condition, args1, args2);
 //       con.cleanerTABLE(name);
 //       con.dropTable(name);
 
    String pathName ="description of fields.csv";
    ArrayList parsedFile = FileParser.Parser(pathName);
    String [][] arrF ;
     FileParser.ArrayListToArray(parsedFile);
    }

}
