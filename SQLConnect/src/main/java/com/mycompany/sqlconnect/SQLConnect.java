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
        var pass = "POSTGRES";
        var name = "my_table";
//        var condition = "v_id=25";
//        var col4 = "cucumber text";
//
//        String[][] rows = {{"25", "'rtyy'", "'ert'"}, {"34", "'tgtg'", "'34'"}, {"432", "'fdgdf'", "'dfgdf'"}};
        con.connect(url, user, pass);
//
//        var arr = new String[3];
//        arr[0] = "v_id SERIAL";
//        arr[1] = "v_name text";
//        arr[2] = "potato varchar(10)";
//        

//        if (con.create(name, arr)) {
//            System.out.println("YES, create.");
//        }
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
 //name = "products";
  //      con.dropTable(name);
 
    String pathName ="description of fields.csv";
    ArrayList parsedFile = FileParser.Parser(pathName);
    String [][] arrF ;
     arrF = FileParser.ArrayListToArray(parsedFile);
     
     String[] Fields = new String [arrF.length-1];
     
     // берём имя таблицы из матрицы
     name = arrF[0][0];
      // сохраняем массив с полями 
     for(int i= 1;i<arrF.length;i++)         
     {
         Fields[i-1] = arrF[i][0]+" "+arrF[i][1];
          System.out.println("поля "+Fields[i-1]);
     }
     
     if (con.create(name, Fields)) {
            System.out.println("YES,table create.");
     }      
     // устанавливаем ограничения ,primary key
     String columnsPK="";
     for(int i= 1;i<arrF.length;i++)
     {
         String PK = arrF[i][2];
        if(PK.equalsIgnoreCase("pk"))
        {
            columnsPK=columnsPK+arrF[i][0]+",";
            
        } 
         String column=arrF[i][0];
         String constraint = arrF[i][2];
     
        if(con.AddUniqueConstraint(name, column, constraint))
        {
        System.out.println("__constraint++__");
        }
     }
     
    columnsPK = columnsPK.substring(0, columnsPK.length() - 1);
    
    con.PrimaryKey(name, columnsPK);
   
     
   }
}
