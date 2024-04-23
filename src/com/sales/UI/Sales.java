package com.sales.UI;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sales.DAL.DALUtility;
import com.sales.DAL.CashiersDAL;
import com.sales.DAL.CustomersDAL;
import com.sales.DAL.SalesPersonsDAL;

import com.sales.library.Cashier;
import com.sales.library.Customer;
import com.sales.library.SalesPerson;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fawad
 */
public class Sales {

    /**
     * @param args the command line arguments
     */
    //protected static List<Object> myList; // Not Allowed Geric???
    protected static List<com.sales.library.Cashier> myList;
    protected static List<com.sales.library.Customer> myList2;
    protected static List<com.sales.library.SalesPerson> myList3;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //DALUtility dal = new DALUtility();
        
        //######### Cashier DATA Aces Layer Test ##########
        System.out.println("//######### Cashier DATA Acess Layer Test ##########");
        CashiersDAL  cashiers = new CashiersDAL();
        try {
            myList = cashiers.GetCashiers();
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Cashier cashier:myList){  System.out.println(cashier.ToString());}
        
        //######### Customer DATA Aces Layer Test ##########
        System.out.println("//######### Customer DATA Acess Layer Test ##########");
        CustomersDAL customers = new CustomersDAL();
        try {
            myList2 = customers.GetCustomers();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Customer customer:myList2){  System.out.println(customer.ToString());}
        
        //######### SalesPerson DATA Aces Layer Test ##########
        System.out.println("//######### SalesPerson DATA Acess Layer Test ##########");
        SalesPersonsDAL salespersons = new SalesPersonsDAL();
        try {
            myList3 = salespersons.GetSalesPersons();
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (SalesPerson salesperson:myList3){  System.out.println(salesperson.ToString());}
        System.out.println("google");
    }
    
}
