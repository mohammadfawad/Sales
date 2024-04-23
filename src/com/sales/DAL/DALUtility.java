/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.DAL;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fawad
 */
public class DALUtility {
     private static  String DB_URL ;
     private static  String JDBC_DRIVER ;
     private static  String PASS ;
     private static  String USER;
     private Connection CONN;
     private static final String ERROR = "ERROR IN GETTING DATABASE CREDENTIALS , CHECK DB CONNECTION PROPERTIES\n";
      private static final String ERROR2 = "ERROR IN GET CONNECTION , CHECK DB CONNECTION PROPERTIES\n";

    public DALUtility() throws InstantiationException, IllegalAccessException {
        try (FileReader reader = new FileReader("SalesProperties.properties")) {
            Properties properties = new Properties();
            properties.load(reader);
            
            DB_URL = properties.getProperty("DB_URL");
            JDBC_DRIVER = properties.getProperty("JDBC_DRIVER");
            PASS = properties.getProperty("PASS");
            USER = properties.getProperty("USER");
            try {
                Class.forName(JDBC_DRIVER).newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DALUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                
                CONN = DriverManager.getConnection(DB_URL,USER,PASS);
                //if(CONN.isValid(90)){System.out.println("IS connected to db");}
            }
                catch (SQLException ex) {
                Logger.getLogger(DALUtility.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ERROR2);
            }
                
                
        } catch (IOException e) {
            System.out.println(ERROR);

        }

    }//end of constructor
    public Connection getConnection(){
        return CONN;
    }
    public String getDburl(){
        return DB_URL;
    }
    public String getJdbc(){
        return JDBC_DRIVER;
    }
    public String getPassword(){
        return PASS;
    }
    public String getUserName(){
        return USER;
    }
    
}//end of class
            
//            try {
//                CONN = DriverManager.getConnection(DB_URL,USER,PASS);
//                if(CONN.isValid(90)){System.out.println("IS connected to db");}
////            System.out.println(DB_URL);
////            System.out.println(JDBC_DRIVER);
////            System.out.println(PASS);
////            System.out.println(USER);
//            } catch (SQLException ex) {
//                Logger.getLogger(DALUtility.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println(ERROR2);
//            }