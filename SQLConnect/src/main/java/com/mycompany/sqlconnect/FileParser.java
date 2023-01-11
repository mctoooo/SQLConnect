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
    
  ArrayList Parser(String fileName){
      try{
    
            CSVReader reader = new CSVReader(new FileReader(fileName)); 

                ArrayList TableCSV = new ArrayList<String[]>();
                String[] lineInArray;

                for(lineInArray = reader.readNext(); lineInArray != null; lineInArray = reader.readNext()){
                    TableCSV.add (lineInArray);
                }
                
                System.out.println("file: " + fileName);

             reader = new CSVReader(new FileReader(fileName));
                while((lineInArray  = reader.readNext()) != null)
                {
                    for(String line: lineInArray)
                        System.out.print(line + " ");
                    System.out.println();
                }
                
            
       
        } catch (Exception ex) 
        {
            return null;
        }
      return TableCSV;    
    }
}

