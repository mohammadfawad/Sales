/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.library;

import java.io.Serializable;

/**
 *
 * @author fawad
 */
public class Cashier extends Employee implements Serializable {

    
    public Cashier() {
    }

    public Cashier(int empCode, String name) {
    
        super(empCode, name);
    }
    @Override
    public void DoYourJob() {
        System.out.println("Record Sales");
    }
    public  String ToString() {
        
        return String.valueOf(this.getEmployeeCode()) + "," + this.getName();
    }

    

}
