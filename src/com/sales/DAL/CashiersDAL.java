/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.DAL;

import com.sales.library.Cashier;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author fawad
 */
public class CashiersDAL {

    private static final String selectAllCashiers = "Select cashiers.ID, cashiers.Name From sales.Cashiers";
    DALUtility DALUtility;
    Statement stmt;
    Connection con;

    public List<Cashier> GetCashiers() throws SQLException, InstantiationException, IllegalAccessException {

        DALUtility = new DALUtility();
        con = DALUtility.getConnection();
        stmt = con.createStatement();
        List<Cashier> cashiers = null;
        
        try (ResultSet rs = stmt.executeQuery(CashiersDAL.selectAllCashiers)) {

            cashiers = new ArrayList<>();
            while (rs.next()) {
                Cashier c = new Cashier(rs.getInt("ID"), rs.getString("Name"));
                cashiers.add(c);
            }
       stmt.close();
       con.close();
        }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(con!=null)
            con.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
        
    return cashiers ;
}
}
