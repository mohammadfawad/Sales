/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.DAL;

import com.sales.library.Customer;
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
public class CustomersDAL {

    private static final String selectAllCustomers = "Select Customers.ID , Customers.Name From sales.Customers";
    DALUtility DALUtility;
    Statement stmt;
    Connection con;

    public List<Customer> GetCustomers() throws IllegalAccessException, InstantiationException, SQLException {
        DALUtility = new DALUtility();
        con = DALUtility.getConnection();
        stmt = con.createStatement();
        List<Customer> customers = null;

        try (ResultSet rs = stmt.executeQuery(CustomersDAL.selectAllCustomers)) {

            customers = new ArrayList<>();
            while (rs.next()) {
                Customer c = new Customer(rs.getInt("ID"), rs.getString("Name"));
                customers.add(c);

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

        return customers;
    }
}
