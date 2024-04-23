/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.DAL;

import com.sales.library.SalesPerson;
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
public class SalesPersonsDAL {

    private static final String selectAllSalesPersons = "Select SalesPersons.ID,SalesPersons.Name,SalesPersons.CommissionRate from sales.SalesPersons";
    DALUtility DALUtility;
    Statement stmt;
    Connection con;

    public List<SalesPerson> GetSalesPersons() throws SQLException, IllegalAccessException, InstantiationException {
        DALUtility = new DALUtility();
        con = DALUtility.getConnection();
        stmt = con.createStatement();
        List<SalesPerson> salesPersons = null;

        try (ResultSet rs = stmt.executeQuery(SalesPersonsDAL.selectAllSalesPersons)) {

            salesPersons = new ArrayList<>();
            while (rs.next()) {

                SalesPerson c = new SalesPerson(rs.getInt("ID"), rs.getString("Name"), rs.getFloat("CommissionRate"));
                salesPersons.add(c);
            }
            stmt.close();
            con.close();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }//end finally try
        }//end try

        return salesPersons;
    }

}
