/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sqlconnect;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class FileParser {
/**
 * 
 * @param pathName-path of the file.csv
 * @return ArrayList<String[]> where each cell contains one file line element. (else if the file does not exist return null)
 */    
  public static ArrayList<String[]> Parser(String pathName){
      try{
    
            CSVReader reader = new CSVReader(new FileReader(pathName)); 

                ArrayList TableCSV = new ArrayList<String[]>();
                String[] lineInArray;

                for(lineInArray = reader.readNext(); lineInArray != null; lineInArray = reader.readNext()){
                    TableCSV.add (lineInArray);
                }
                
                System.out.println("file: " + pathName);

             reader = new CSVReader(new FileReader(pathName));
                while((lineInArray  = reader.readNext()) != null)
                {
                    for(String line: lineInArray)
                        System.out.print(line + " ");
                    System.out.println();
                }
                            
       return TableCSV;
        } catch (Exception ex) 
        {
            return null;
        }
  }
      
        public static String[][] ArrayListToArray(ArrayList<String[]>list){
            String [] array=(String[])list.toArray();
            
            System.out.print(array.toString());
//            int size = list.size();
//            for(String[] listTo:list){
//                
//            }
            return null;
        }
        
          
    }


