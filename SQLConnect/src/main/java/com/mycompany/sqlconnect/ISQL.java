/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sqlconnect;

import java.sql.Connection;

/**
 *
 * @author Student
 */
public interface ISQL extends AutoCloseable{
    boolean connect(String url, String username, String password);
}