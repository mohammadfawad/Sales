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
public abstract class Employee extends Person implements Serializable {

    private int employeeCode;
    private int salary;

    public Employee() {

    }

    public Employee(int empCode, String name) {
            super(name);
            this.employeeCode = empCode;
    }

    public int getEmployeeCode(){
        
            return this.employeeCode;
    }
    public void setEmployeeCode(int value){
        
            this.employeeCode = value;
    }

    public int getSalary(){
        
            return this.salary;
    }
    public void gsetetSalary(int value){
       
            this.salary = value;
        
    }
}
